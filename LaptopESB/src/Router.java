import javax.jms.JMSException;
import javax.naming.NamingException;

import org.jboss.soa.esb.listeners.message.MessageDeliverException;

import splitter.SplitAction;
import util.Agent;

import laptop.Apple;
import laptop.Asus;


	
	public class Router {

		
		public static void main(String[] args) throws NamingException, JMSException {
			
			SplitAction x= new SplitAction();
			
			try {
				x.split_msg(null);
			} catch (MessageDeliverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	