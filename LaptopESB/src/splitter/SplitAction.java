package splitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.naming.NamingException;

import laptop_router.RouteAction;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;

import util.Agent;

import org.jboss.soa.esb.message.format.MessageFactory;
import org.jboss.soa.esb.client.ServiceInvoker;

public class SplitAction extends AbstractActionLifecycle{

	protected ConfigTree _config;

	public SplitAction(ConfigTree config) {
		_config = config;
	}
	public SplitAction(){
		
	}

	public void split_msg(String aux) throws MessageDeliverException, NamingException, JMSException {
		
		Message message = MessageFactory.getInstance().getMessage();
		message.getBody().add(aux);
		

		Map<String, Object> outmap = new HashMap<String, Object>();
		
		outmap.put("body", message.getBody().get());
		outmap.put("ContextInfo", message.getContext().getContext("aggregatorTag"));
		message.getBody().add(outmap);
		
		
		Agent aping = new Agent();
		aping.send("/queue/AsusSplitter",(Map<String, Object>) outmap);
		aping.finish();
		
		
		RouteAction route=new RouteAction(null);
		route.route_msg(null);
	}
}