package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorConsumer {
	public static final String select = "name='Han' and age=400 ";
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		Queue queue = session.createQueue("select");
		
		MessageConsumer consumer = session.createConsumer(queue,select);
		TextMessage msg = (TextMessage) consumer.receive();
		System.out.println(msg.getText().toString());
		
		msg.acknowledge();
	}
	
}
