package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorProducer {
	
	public static void main(String[] args)throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = session.createQueue("selector");
		
		MessageProducer producer = session.createProducer(queue);
		
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		TextMessage msg = session.createTextMessage("山东省：济南市");
		msg.setStringProperty("name", "etoak");
		msg.setIntProperty("age", 11);
		
		TextMessage msg2 = session.createTextMessage("济南市：泉城路");
		msg2.setStringProperty("name", "etoak");
		msg2.setIntProperty("age", 2);
		
		producer.send(msg);
		producer.send(msg2);
		
		producer.close();
		session.close();
		connection.close();
		
	}
}
