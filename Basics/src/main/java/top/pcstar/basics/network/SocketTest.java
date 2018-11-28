package top.pcstar.basics.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 22:56 2018/8/11
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13);

        try (InputStream inputStream = socket.getInputStream()) {
            int i;
            while ((i = inputStream.read()) > 0) {
                System.out.print((char) i);
            }
        }
    }
}
