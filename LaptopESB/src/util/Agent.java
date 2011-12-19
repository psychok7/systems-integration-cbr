package util;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Agent {
	protected InitialContext init;
	protected ConnectionFactory cf;
	protected Connection conn;
	protected Session session;
	
	public Agent() throws NamingException, JMSException {
		init = new InitialContext();
		cf = (ConnectionFactory) init.lookup("ConnectionFactory");
		conn = cf.createConnection();
		createSession();
		conn.start();
	}
	
	protected void createSession() throws JMSException {
		session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
	}
	
	public void send(String outboxname, String text) throws NamingException, JMSException {
		Destination outbox = (Destination) init.lookup(outboxname);
		MessageProducer sndr = session.createProducer(outbox);
		TextMessage msg = session.createTextMessage(text);
		sndr.send(msg);
		sndr.close();
	}
	
	public String receive(String inboxname) throws NamingException, JMSException {
		Destination inbox = (Destination) init.lookup(inboxname);
		MessageConsumer cnsmr = session.createConsumer(inbox);
		TextMessage replymsg = (TextMessage) cnsmr.receive();
		cnsmr.close();
		return replymsg.getText();
	}
	
	public void finish() throws JMSException {
		conn.close();
	}
}

