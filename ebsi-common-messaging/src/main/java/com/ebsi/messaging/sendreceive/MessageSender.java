/**
 * 
 */
package com.ebsi.messaging.sendreceive;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.ebsi.common.dtos.BaseVO;

/**
 * @author 
 * JMS message producer which produce the message with different formats 
 * and send it to Messaging Queue
 *
 */
@Component(value="Receiver")
public class MessageSender {
	
	@Autowired
	  private JmsTemplate jmsTemplate;
	   
	   
	  /**
	   * send text to default destination
	   * @param text
	   */
	  public void send(final String text) {
	    this.jmsTemplate.send(new MessageCreator() {
	      @Override
	      public TextMessage createMessage(Session session) throws JMSException {
	        TextMessage message = session.createTextMessage(text);
	        return message;
	      }
	    });
	  }
	  
	  /**
	   * Send any custom object to default destination configured in xml files
	   * @param text
	   */
	  public <T extends BaseVO> void send(final T baseVO) {	     
	    this.jmsTemplate.send(new MessageCreator() {
	      @Override
	      public ObjectMessage createMessage(Session session) throws JMSException {
	        ObjectMessage message = session.createObjectMessage();
	        message.setObject(baseVO);
	        return message;
	      }
	    });
	  }
	   
	  /**
	   * Simplify the send by using convertAndSend
	   * @param text
	   */
	  public void sendText(final String text) {
	    this.jmsTemplate.convertAndSend(text);
	  }
	   
	  /**
	   * Send text message to a specified destination
	   * @param text
	   */
	  public void send(final Destination dest,final String text) {
	     
	    this.jmsTemplate.convertAndSend(dest,new MessageCreator() {
	      @Override
	      public Message createMessage(Session session) throws JMSException {
	        Message message = session.createTextMessage(text);
	        return message;
	      }
	    });
	  }
	  
	  /**
	   * Send Custom object as a message to a specified destination
	   * @param text
	   */
	  public void send(final Destination dest,final BaseVO obj) {
	     
	    this.jmsTemplate.convertAndSend(dest,new MessageCreator() {
	      @Override
	      public Message createMessage(Session session) throws JMSException {
	        ObjectMessage message = session.createObjectMessage();
	        message.setObject(obj);
	        return message;
	      }
	    });
	  }
}
