package laptop_search;

import java.util.HashMap;
import java.util.Map;


import javax.jms.JMSException;
import javax.naming.NamingException;

import util.Agent;
import util.XmlManager;


public class HP {


	private static Map<String,Object> manage(Agent agent){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("hp",new XmlManager().convertXMLFileToString("xmldb/HP.xml"));
		map.put("body", map2);
		try {
			map.put("ContextInfo",agent.receive("queue/hp_store").get("ContextInfo"));
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