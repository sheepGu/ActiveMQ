package activemq2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听
 */
public class Listener2 implements MessageListener {

    @Override
    public void onMessage(Message message){
        try {
            System.out.println("一收到消息"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
