package laptop;

import util.Agent;

public class HP extends Thread {
	private Agent ba;

	public HP(Agent ba) {
		this.ba = ba;
	}

	public void run() {
		try {
			ba.send("/queue/Pong","HelloPong,Ping");
			String res = ba.receive("/queue/Ping");
			System.out.println("Ping got: " + res);
			ba.finish();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
