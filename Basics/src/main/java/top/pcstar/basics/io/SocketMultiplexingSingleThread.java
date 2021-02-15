package top.pcstar.basics.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketMultiplexingSingleThread {
    private ServerSocketChannel server = null;
    private Selector selector = null; //linux 多路复用器（select poll epoll kqueue）
    int port = 9090;

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            //如果在epoll模型下,open-->epoll_create-->fd3
            selector = Selector.open(); //select poll *epoll 优先选择：epoll 但是可以通过-D修改

            //server-->lister状态 fd4
            /*
            register
            如果：
            select、poll：jvm里开辟一个数组 fd4放进去
            epoll： epoll_ctl(fd3,ADD,fd4,EPOLLIN
             */
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("服务启动了。。。。。。");

        try {
            while (true) {
                Set<SelectionKey> keys = selector.keys();
                System.out.println(keys.size() + " size");

                //1.调用多路服用器（select、poll or epoll (epoll_wait)）
                /*
                select()是什么意思：
                1.select、poll其实是内核的select(fd4) poll(fd4)
                2.epoll其实是内核的epoll_wait();
                *.参数可以带时间：没有时间，0：阻塞，有时间设置一个超时
                selector.wakeup() 结果返回0

                懒加载：
                其实在碰触到selector.select()调用的时候触发了epoll_ctl的调用
                 */
                while (selector.select() > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys(); //返回有状态的fd集合
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();//set 不移出会重复循环处理
                        if (key.isAcceptable()) {
                            //接受一个新的连接
                            //语义上，accept接受连接且返回新连接的FD
                            //新连接如何处理：
                            //select、poll，因为他们内核没有空间，那么在jvm中保存和前边fd4那个listen的一起
                            //epoll：我们希望通过epoll_ctl把新的客户端fd注册到内核空间
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key); //连read还有write都处理了
                            //在当前线程，这个方法可能会阻塞，如果阻塞十年，其他IO早就没电了
                            //所以，为什么提出了IO THREADS
                            //redis 是不是用了epoll，redis是不是有个io threads的概念，redis是不是单线程
                            //tomcat 8,9  异步处理方式 IO和处理上 解耦
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();//调用accept接收客户端 fd7
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(8192);

            //调用register
            /*
            select,poll:jvm里开辟一个数组 fd7放进去
            epoll: epoll_ctl(fd3,ADD,fd7,EPOLLIN
             */
            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("--------------------------------");
            System.out.println("新客户端：" + client.getRemoteAddress());
            System.out.println("--------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readHandler(SelectionKey key) {

        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        buffer.clear();
        int read = 0;
        try {
            while (client.read(buffer) > 0) {
                buffer.flip();
                byte[] aaa = new byte[buffer.limit()];
                buffer.get(aaa);

                String b = new String(aaa);
                System.out.println(client.socket().getPort() + ":" + b);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketMultiplexingSingleThread socketMultiplexingSingleThread = new SocketMultiplexingSingleThread();
        socketMultiplexingSingleThread.start();
    }
}
