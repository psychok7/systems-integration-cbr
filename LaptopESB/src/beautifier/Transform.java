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

		String transform = "xsl/transformbrand.xsl";

		while(true){
			try{

				Agent a = new Agent();
				Map<String,String> resp;

				resp=(Map<String,String>) a.receiveFinal("queue/beautifier");
				HashMap<String,Object> toReturn=new HashMap<String, Object>();
				for(String i:resp.keySet()){
					System.out.println("Chave: "+i);
					System.out.println("Valor: "+resp.get(i));
//					TransformerFactory tFactory = TransformerFactory.newInstance();
//					Source xmlSource = new StreamSource(resp.get(i));
//					Source xslSource = new StreamSource(new File("transformbrand.xsl"));
//					Transformer transformer = tFactory.newTransformer(xslSource);
//					StreamResult result=new StreamResult(new StringWriter());
//					transformer.transform(xmlSource, result);
//
//					toReturn.put(i,result.getWriter());

				}

//				a.sendObject("queue/client", toReturn);
				a.finish();

			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
