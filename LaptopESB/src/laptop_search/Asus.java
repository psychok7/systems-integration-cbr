package laptop_search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.naming.NamingException;

import util.Agent;
import util.XmlManager;


public class Asus {

	public static void main(String[] args){
		while(true){
			try {
				Agent agent = new Agent();
				Map<String,Object> map=agent.receive("queue/asus_store");

				System.out.println("[ASUS_STORE]  Recebi um pedido! "+map.get("body"));

				Map<String,Object> map2 = new HashMap<String,Object>();
				Map<String,Object> map3 = new HashMap<String,Object>();
				map3.put("asus",new XmlManager().convertXMLFileToString("xmldb/Asus.xml"));
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