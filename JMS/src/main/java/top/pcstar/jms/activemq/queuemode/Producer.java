package top.pcstar.jms.activemq.queuemode;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 生产者：发送消息
 * 
 * @author PANCHAO
 *
 */
public class Producer {
	private static final String URL = "tcp://192.168.199.106:61616";
	private static final String QUEUE_NAME = "queue-test";

	public static void main(String[] args) {
		// 1,创建ConnectionFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		Connection connection = null;
		try {
			// 2,创建连接Connection
			connection = connectionFactory.createConnection();
			// 3,启动连接
			connection.start();
			// 4,创建会话Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 5,创建一个目标Destination
			Destination destination = session.createQueue(QUEUE_NAME);
			// 6,创建生产者MessageProducer
			MessageProducer messageProducer = session.createProducer(destination);
			for (int i = 0; i < 100; i++) {
				// 7,创建消息TextMessage
				TextMessage textMessage = session.createTextMessage("消息"+i);
				// 8,发送消息
				messageProducer.send(textMessage);
			}
		} catch (JMSException e) {
			System.out.println("消息发送失败!");
			e.printStackTrace();
		}finally {
			// 9,关闭连接Coonection
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			System.out.println("消息发送成功!");
		}
	}
}
