//package laptop_search;
//
//import java.util.HashMap;
//
//import javax.jms.ObjectMessage;
//
//import util.Agent;
//
//	public class Apple extends Thread {
//		Agent ba;
//		private Object obj;
//		
//		public Apple(Agent ba) {
//			this.ba = ba;
//		}
//		
//		
//		public void setObj(Object obj) {
//			this.obj = obj;
//		}
//
//
//		public Object getObj() {
//			return obj;
//		}
//
//
//		@SuppressWarnings("unchecked")
//		public void run() {
//			try {
//				ObjectMessage res = ba.receive("/queue/AsusSplitter");
//				System.out.println("Pong got: " + res.getObject());
//				ba.send("/queue/AppleSplitter",(HashMap<String, Object>) getObj());
//				ba.finish();
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}