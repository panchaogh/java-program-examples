package top.pcstar.basics.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 9:16 2018/8/12
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            int i = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("第" + (++i) + "个线程!");
                ThreadEchoHandler threadEchoHandler = new ThreadEchoHandler(socket);
                Thread thread = new Thread(threadEchoHandler);
                thread.start();
            }
        }
    }
}

class ThreadEchoHandler implements Runnable {
    private Socket socket;

    public ThreadEchoHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {
                try (Scanner scanner = new Scanner(inputStream)) {
                    PrintWriter printWriter = new PrintWriter(outputStream, true);
                    printWriter.println("Hello! Enter BYE to exit.");
                    boolean done = false;
                    while (!done && scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        printWriter.println("Echo:" + line);
                        if ("BYE".equalsIgnoreCase(line.trim())) done = true;
                    }
                }
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
