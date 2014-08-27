package com.trungnd.activemq.demo.topic;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MainProducer {
	public static void main(String[] args) {
		HelloWorldProducer producer = new HelloWorldProducer();
		producer.run();
	}

	public static class HelloWorldProducer implements Runnable {
		public void run() {
			try {
				// Create a ConnectionFactory
//				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
//						"vm://localhost");
//				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
//						"tcp://localhost:61616");
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
						Utils.connectionUrl);

				// Create a Connection
				Connection connection = connectionFactory.createConnection();
				connection.start();

				// Create a Session
				Session session = connection.createSession(false,
						Session.AUTO_ACKNOWLEDGE);

				// Create the destination (Topic or Queue)
				Destination destination = session.createTopic(Utils.destinationName);

				// Create a MessageProducer from the Session to the Topic or
				// Queue
				MessageProducer producer = session.createProducer(destination);
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

				// Create a messages
				String text = "Trungnd10! From: "
						+ Thread.currentThread().getName() + " : "
						+ this.hashCode();
				TextMessage message = session.createTextMessage(text);

				// Tell the producer to send the message
				System.out.println("Sent message: " + message.hashCode()
						+ " : " + Thread.currentThread().getName());
				producer.send(message);

				// Clean up
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}
	}
}
