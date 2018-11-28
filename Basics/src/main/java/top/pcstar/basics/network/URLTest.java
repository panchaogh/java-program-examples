package top.pcstar.basics.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 23:45 2018/8/11
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://news.sina.com.cn");
        try (InputStream inputStream = url.openStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}
