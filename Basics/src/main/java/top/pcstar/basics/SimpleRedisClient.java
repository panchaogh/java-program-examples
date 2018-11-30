package top.pcstar.basics;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 简单实现redis客户端
 */
public class SimpleRedisClient {
    private OutputStream outputStream;
    private InputStream inputStream;

    public SimpleRedisClient(String host, int post) throws IOException {
        Socket socket = new Socket(host,post);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    /**
     * 写数
     * @param key
     * @param value
     */
    public boolean set(String key,String value) throws IOException {
        // 1、 组装数据
        StringBuffer data = new StringBuffer();

        data.append("*3").append("\r\n");

        data.append("$3").append("\r\n");

        data.append("SET").append("\r\n");

        data.append("$").append(key.getBytes().length).append("\r\n");

        data.append(key).append("\r\n");

        data.append("$").append(value.getBytes().length).append("\r\n");

        data.append(value).append("\r\n");

        // 2、 把指令数据发给Redis服务端

        outputStream.write(data.toString().getBytes());
        // 3、 接收服务端响应
        byte[] response = new byte[1024];

        inputStream.read(response);
        String temp = new String(response);
        String[] split = temp.split("\r\n");
        System.out.println("接收到响应：" + split[0]);
        return true;

    }

    /**
     * 读数
     * @param key
     */
    public String get(String key) throws IOException {
        // 1、 组装数据
        StringBuffer data = new StringBuffer();
        data.append("*2").append("\r\n");

        data.append("$3").append("\r\n");

        data.append("GET").append("\r\n");

        data.append("$").append(key.getBytes().length).append("\r\n");

        data.append(key).append("\r\n");

        // 2、 把指令数据发给Redis服务端

        outputStream.write(data.toString().getBytes());
        // 3、 接收服务端响应
        byte[] response = new byte[1024];

        inputStream.read(response);
        String temp = new String(response);
        String[] split = temp.split("\r\n");
        return split[1];
    }

    public static void main(String[] args) throws IOException {
        SimpleRedisClient redisClient = new SimpleRedisClient("127.0.0.1", 6379);
        redisClient.set("name", "潘超");
        System.out.println(redisClient.get("name"));
    }

}
