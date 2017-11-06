import javax.jms.*;

import activemq2.Listener2;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class Receiver2 {

    private static  final   String  MESSAGE_QUEUE="zhangphil";
    private final static    int PORT=61616;

    public static void main(String[] args) {

        // ConnectionFactory ：连接工厂，JMS 用它创建连接  
        ConnectionFactory connectionFactory;

        // Connection ：JMS 客户端到JMS Provider 的连接  
        Connection connection = null;

        // Session： 一个发送或接收消息的线程  
        Session session;

        // Destination ：消息的目的地;消息发送给谁.  
        Destination destination;

        // 消息接收者  
        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, "tcp://127.0.0.1:"+PORT);

        try {
            // 构造从工厂得到连接对象  
            connection = connectionFactory.createConnection();

            // 启动  
            connection.start();

            // 获取操作连接  
            session = connection.createSession(Boolean.FALSE.booleanValue(), Session.AUTO_ACKNOWLEDGE);

            // 获取session注意参数值 zhangphil 是一个服务器的queue，只接受相同message queue字段的消息。  
            destination = session.createQueue(MESSAGE_QUEUE);

            consumer = session.createConsumer(destination);
            consumer.setMessageListener(new Listener2());//注册消息监听
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}  