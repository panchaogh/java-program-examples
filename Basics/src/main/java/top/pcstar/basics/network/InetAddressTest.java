package top.pcstar.basics.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 23:15 2018/8/11
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        InetAddress remoteHost = InetAddress.getByName("www.qq.com");
        InetAddress[] remoteHosts = InetAddress.getAllByName("www.qq.com");
        System.out.println("本机IP地址:"+localHost.getHostAddress());
        System.out.println("本机机器名:"+localHost.getHostName());
        System.out.println("QQ网IP:"+remoteHost.getHostAddress());
        System.out.println("QQ网所有IP:"+ Arrays.toString(remoteHosts));
    }
}
