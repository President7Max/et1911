package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProducer {

	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		Queue helloQueue = session.createQueue("hello");
		
		MessageProducer producer = session.createProducer(helloQueue);
		
		TextMessage msg = session.createTextMessage("第一个HelloWorld");
		
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
		
		System.out.println("OK");
	}

}
