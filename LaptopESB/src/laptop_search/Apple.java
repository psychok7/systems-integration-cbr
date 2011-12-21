package laptop_search;


import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.naming.NamingException;

import util.Agent;
import util.XmlManager;


public class Apple {


	private static Map<String,Object> manage(Agent agent){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("apple",new XmlManager().convertXMLFileToString("xmldb/Apple.xml"));
		map.put("body", map2);
		try {
			map.put("ContextInfo",agent.receive("queue/apple_store").get("ContextInfo"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static void main(String[] args){
		while(true){
			try {
				Agent agent = new Agent();				
				agent.sendObject("queue/aggregator",manage(agent));
				System.out.println("apple funca");
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