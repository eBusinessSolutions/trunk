/*
 * MessageReceiver.java
 * JMS consumer to receive text message, object message etc.. from the queue and process it
 */
package com.ebsi.messaging.sendreceive;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ebsi.common.dtos.UserVO;

@Component(value="Consumer")
public class MessageReceiver {

   
    /**
     * receiveMessage has a listener interface and which listen's the destination queue
     * for Custom objects
     * @param objMessage
     * @throws InterruptedException
     * @throws JMSException 
     */
    @JmsListener(destination = "mailbox-destination", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Message message) throws InterruptedException, JMSException {
    	
    	if(message instanceof ObjectMessage){
    		if(((ObjectMessage)message).getObject() instanceof UserVO){
    			UserVO userVO = (UserVO)((ObjectMessage)message).getObject();
    			System.out.println("User Logged in::"+userVO.getFirstName().concat(" ").concat(userVO.getLastName()));
    		}
    		/*
    		 * Add custom VOs conversion
    		 */	
    	}else if(message instanceof TextMessage){
    		System.out.println("Received text message::"+((TextMessage)message).getText());
    	}
    	/*
    	 * Add new blocks for further implementation with various custom messages like map message, stream message etc...
    	 * 
    	 */
        
    }
}