package top.pcstar.jms.activemq.queuemode;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消费者：接收消息
 * @author PANCHAO
 *
 */
public class Consumer {
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
					// 6,创建消费者MessageConsumer
					MessageConsumer messageConsumer = session.createConsumer(destination);
					// 7,创建一个监听器
					messageConsumer.setMessageListener(new MessageListener() {
						
						@Override
						public void onMessage(Message message) {
							TextMessage textMessage = (TextMessage) message;
							try {
								System.out.println(textMessage.getText());
							} catch (JMSException e) {
								e.printStackTrace();
							}
						}
					});
				} catch (JMSException e) {
					System.out.println("消息接收失败!");
					e.printStackTrace();
				}finally {
					// 9,关闭连接Coonection
					/**
					 * 不能当场关闭连接，因为接受消息是异步的
					 */
//					if (connection != null) {
//						try {
//							connection.close();
//						} catch (JMSException e) {
//							e.printStackTrace();
//						}
//					}
					System.out.println("消息接收成功!");
				}
	}
}
