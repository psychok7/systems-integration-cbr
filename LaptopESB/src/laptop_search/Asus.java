//package laptop_search;
//
//import java.util.HashMap;
//
//import javax.jms.ObjectMessage;
//
//import util.Agent;
//
//public class Asus extends Thread {
//	private Agent ba;
//	private Object obj;
//
//	public Asus(Agent ba) {
//		this.ba = ba;
//	}
//
//	public void setObj(Object obj) {
//		this.obj = obj;
//	}
//
//
//	public Object getObj() {
//		return obj;
//	}
//	@SuppressWarnings("unchecked")
//	public void run() {
//		try {
//			ba.send("/queue/AsusSplitter",(HashMap<String, Object>) getObj());
//			ObjectMessage res = ba.receive("/queue/AppleSplitter");
//			System.out.println("Ping got: " + res.getObject());
//			ba.finish();
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
