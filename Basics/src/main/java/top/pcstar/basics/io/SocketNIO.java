package top.pcstar.basics.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class SocketNIO {
    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open(); //服务端开启监听:接受客户端
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false); //重点： OS NONLOCKING!! 只让接受客户端 不阻塞

        while (true) {
            //接受客户端的连接
            TimeUnit.SECONDS.sleep(1);
            SocketChannel client = ss.accept(); //不会阻塞？ -1 NULL
            //accept 调用内核
            if (client == null) {
                System.out.println("null......");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client..port:" + port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocate(4096);//可以在堆里 堆外

            //遍历已经链接进来的客户端能不能读写数据
            for (SocketChannel c : clients) { //串行化！！！ 多线程！
                int num = c.read(buffer);
                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + ":" + b);
                    buffer.clear();
                }
            }
        }

    }
}
