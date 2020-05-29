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

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = session.createQueue("selector");
		
		MessageProducer producer = session.createProducer(queue);
		
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		TextMessage msg = session.createTextMessage("嬴政:大秦");
		msg.setStringProperty("name", "Qin");
		msg.setIntProperty("age", 200);
		
		TextMessage msg2 = session.createTextMessage("刘邦:大汉");
		msg2.setStringProperty("name", "Han");
		msg2.setIntProperty("age", 400);
		
		producer.send(msg);
		producer.send(msg2);
		
		producer.close();
		session.close();
		connection.close();
	}

}
