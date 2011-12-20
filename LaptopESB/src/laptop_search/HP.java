package laptop_search;
//package laptop;
//
//import util.Agent;
//
//public class HP extends Thread {
//	private Agent ba;
//
//	public HP(Agent ba) {
//		this.ba = ba;
//	}
//
//	public void run() {
//		try {
//			ba.send("/queue/PongSplitter","HelloPong,Ping");
//			String res = ba.receive("/queue/PingSplitter");
//			System.out.println("Ping got: " + res);
//			ba.finish();
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
