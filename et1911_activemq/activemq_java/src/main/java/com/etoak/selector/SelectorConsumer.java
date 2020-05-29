package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorConsumer {
	
	public static final String selector="name = 'etoak' and age = 11 "; 
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		Queue queue = session.createQueue("selector");
		MessageConsumer consumer = session.createConsumer(queue,selector);
		TextMessage msg = (TextMessage)consumer.receive();
		
		msg.acknowledge();
		
		System.out.println(msg.getText().toString());
		
		
	}
}
