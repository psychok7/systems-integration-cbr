package beautifier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import util.Agent;

public class Transform {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TransformerException 
	 */
	public static void main(String[] args) throws IOException, TransformerException {
//		if (args.length != 3) {
//			System.err.println("Wrong arguments. Correct format: ");
//			System.err.println("Transform inputxml outputhtml transformxsl");
//		}
//		String input = args[0];
//		String output = args[1];
		String transform = "xsl/transformbrand.xsl";

		while(true){
			try{

				Agent a = new Agent();
				Map<String,String> resp;

				resp=(Map<String,String>) a.receiveFinal("queue/toBeautifier");
				HashMap<String,String> toReturn=new HashMap<String, String>();
				for(String i:resp.keySet()){
					//System.out.println("------------------------------"+i);
					TransformerFactory tFactory = TransformerFactory.newInstance();
					Source xmlSource = new StreamSource(resp.get(i));
					Source xslSource = new StreamSource(new File(transform));
					Transformer transformer = tFactory.newTransformer(xslSource);
					StreamResult result=new StreamResult(new StringWriter());
					transformer.transform(xmlSource, result);

					toReturn.put(i,result.getWriter().toString());

				}

			//	a.send("queue/toClient", toReturn);
				a.finish();

			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
