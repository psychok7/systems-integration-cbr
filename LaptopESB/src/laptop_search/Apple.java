package laptop_search;


import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.naming.NamingException;

import util.Agent;
import util.XmlManager;


public class Apple {

	public static void main(String[] args){
		while(true){
			try {
				Agent agent = new Agent();
				Map<String,Object> map=agent.receive("queue/apple_store");
				Map<String,Object> map2 = new HashMap<String,Object>();
				Map<String,Object> map3 = new HashMap<String,Object>();
				map3.put("apple",new XmlManager().convertXMLFileToString("xmldb/Apple.xml"));
				map2.put("body", map3);
				map2.put("ContextInfo",map.get("ContextInfo"));
				agent.sendObject("queue/aggregator",map2);
				agent.finish();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}