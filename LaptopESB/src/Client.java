import javax.jms.JMSException;
import javax.naming.NamingException;

import org.jboss.soa.esb.listeners.message.MessageDeliverException;


import util.Agent;



	
public class Client {
	public static void main(String[] args){

			try {
				Agent a = new Agent();
				a.send("queue/request", "aPPle");
				a.finish();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR: NAMING EXCEPTION");
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR: JMS EXCEPTION");
				e.printStackTrace();
			}
	}
}

	