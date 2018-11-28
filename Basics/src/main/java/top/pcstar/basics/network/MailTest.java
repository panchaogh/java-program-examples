package top.pcstar.basics.network;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 13:40 2018/8/12
 */
public class MailTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.exmail.qq.com");
        properties.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("service@xmjr.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("pcstartop@qq.com"));
        message.setSubject("标题");
        message.setText("正文：方式发范德萨");
        Transport transport = session.getTransport();
        transport.connect("service@xmjr.com", "4RonYvQe3xyrV3tL");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
