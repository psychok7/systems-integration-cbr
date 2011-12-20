package util;


import java.util.HashMap;
import java.util.Map;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;

import java.util.HashMap;
import java.util.Map;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;

public class messageHandler extends AbstractActionLifecycle
{

	 protected ConfigTree _config;

	 public messageHandler(ConfigTree config) {
	  _config = config;
	 }


	public Message keepContext(Message message) throws MessageDeliverException
	{

		Map<String, Object> outmap = new HashMap<String, Object>();
		outmap.put("body", message.getBody().get());
		outmap.put("ContextInfo", message.getContext().getContext("aggregatorTag"));
		message.getBody().add(outmap);
		return message;
	}


	public Message getContextBack(Message message) throws MessageDeliverException
	{
		Map<String, Object> map = (Map<String, Object>) message.getBody().get();
		Object body = (Object) map.get("body");
		message.getBody().add(body);
		Object o=map.get("ContextInfo");
		if(o!=null)
			message.getContext().setContext("aggregatorTag", o);

		return message;
	}
}