package laptop_router;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;

import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;

import util.Agent;

public class RouteAction {

	
	protected ConfigTree _config;

	public RouteAction(ConfigTree config) {
		_config = config;
	}
	
	public void route_msg(String aux) throws MessageDeliverException, NamingException, JMSException {
		
		Agent aping = new Agent();
		Map<String,Object> resp = aping.receive("/queue/AsusSplitter");
		aping.finish();
		String body = (String) resp.get("body");
		System.out.println("routeaction: "+body);
		
	}
	
	
	
	
}
