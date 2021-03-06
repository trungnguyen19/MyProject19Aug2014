package com.trungnd.activemq.demo.topic;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MainConsumer {
	public static void main(String[] args) {
		HelloWorldConsumer consumer = new HelloWorldConsumer();
		consumer.run();
	}

	public static class HelloWorldConsumer implements Runnable,
			ExceptionListener {
		public void run() {
			try {

				// Create a ConnectionFactory
				// ActiveMQConnectionFactory connectionFactory = new
				// ActiveMQConnectionFactory(
				// "vm://localhost");
				// ActiveMQConnectionFactory connectionFactory = new
				// ActiveMQConnectionFactory(
				// "tcp://localhost:61616");
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
						Utils.connectionUrl);

				// Create a Connection
				Connection connection = connectionFactory.createConnection();
				connection.start();

				connection.setExceptionListener(this);

				// Create a Session
				Session session = connection.createSession(false,
						Session.AUTO_ACKNOWLEDGE);

				// Create the destination (Topic or Queue)
				Destination destination = session
						.createTopic(Utils.destinationName);

				// Create a MessageConsumer from the Session to the Topic or
				// Queue
				MessageConsumer consumer = session.createConsumer(destination);

				MessageListener listener = new MessageListener() {
					public void onMessage(Message message) {
						try {
							if (message instanceof TextMessage) {
								TextMessage textMessage = (TextMessage) message;
								System.out.println("Received message"
										+ textMessage.getText() + "'");
							}
						} catch (JMSException e) {
							System.out.println("Caught:" + e);
							e.printStackTrace();
						}
					}
				};

				consumer.setMessageListener(listener);
				Thread.sleep(50000);
				connection.close();

				System.out.println("End!");

				// // Wait for a message
				// Message message = consumer.receive(1000);
				//
				// if (message instanceof TextMessage) {
				// TextMessage textMessage = (TextMessage) message;
				// String text = textMessage.getText();
				// System.out.println("Received: " + text);
				// } else {
				// System.out.println("Received: " + message);
				// }
				//
				// consumer.close();
				// session.close();
				// connection.close();
			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}

		public synchronized void onException(JMSException ex) {
			System.out.println("JMS Exception occured.  Shutting down client.");
		}
	}
}
