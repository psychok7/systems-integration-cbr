package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.w3c.dom.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlManager {

		public XmlManager(){
		
		}
	   public String convertXMLFileToString(String fileName) 
       { 
         try{ 
           DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
           InputStream inputStream = new FileInputStream(new File(fileName)); 
           org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream); 
           StringWriter stw = new StringWriter(); 
           Transformer serializer = TransformerFactory.newInstance().newTransformer(); 
           serializer.transform(new DOMSource(doc), new StreamResult(stw)); 
           return stw.toString(); 
         } 
         catch (Exception e) { 
           e.printStackTrace(); 
         } 
           return null; 
       }
       
   public Document loadXMLFromString(String xml) throws Exception {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       InputSource is = new InputSource(new StringReader(xml));
       return (Document) builder.parse(is);
   }
}
