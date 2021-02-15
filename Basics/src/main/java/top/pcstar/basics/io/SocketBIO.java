package top.pcstar.basics.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketBIO {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9090);
        System.out.println("step1: new ServerSocket(\"9090\")");

        while (true) {
            final Socket client = server.accept(); //阻塞1
            System.out.println("step2: client\t" + client.getPort());

            new Thread(() -> {
                try {
                    InputStream in = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    while (true) {
                        String dataline = br.readLine(); //阻塞2

                        if (null != dataline) {
                            System.out.println(dataline);
                        } else {
                            client.close();
                            break;
                        }
                    }
                    System.out.println("客户端断开");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
