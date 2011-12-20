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


public class HP {

	public static void main(String[] args){
		while(true){
			try {
				Agent agent = new Agent();

				 Map<String,Object> resp=agent.receive("queue/hp_store");

				System.out.println("[HP_STORE]  Recebi um pedido! "+resp.get("body"));

				File file = new File("xmldb/Asus.xml");
			
	//			XmlManager manager= new XmlManager();
	//			String teste=manager.convertXMLFileToString("./HP.xml");
	//			System.out.println(teste);
				
//				Scanner scan = new Scanner(file);  
//				scan.useDelimiter("\\Z");  
//				String content = scan.next();
//				System.out.println("[APPLE_STORE]\n"+content+"\n\n");

				Map<String,Object> resp2 = new HashMap<String,Object>();
				Map<String,Object> resp3 = new HashMap<String,Object>();
	//			resp3.put("hp",file);
				resp2.put("body", resp3);
				resp2.put("ContextInfo",resp.get("ContextInfo"));
	//			agent.send(resp2);
				agent.finish();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				System.out.println("[ASUS_STORE] ERROR: NAMING EXCEPTION");
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				System.out.println("[ASUS_STORE] ERROR: JMS EXCEPTION");
				e.printStackTrace();
			}

		}

	}

}