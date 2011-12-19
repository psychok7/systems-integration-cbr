package splitter;

import java.util.ArrayList;

import javax.jms.JMSException;
import javax.naming.NamingException;

import laptop.Apple;
import laptop.Asus;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;

import util.Agent;



public class SplitAction {

	protected ConfigTree _config;

	public SplitAction(ConfigTree config) {
		_config = config;
	}
	public SplitAction(){
		
	}

	public void split_msg(Message message) throws MessageDeliverException, NamingException, JMSException {
		System.out.println("chegou");
		Agent aping = new Agent();
		Asus pi = new Asus(aping);
		pi.start();
		Agent apong = new Agent();
		Apple po = new Apple(apong);
		po.start();
		
	}
}