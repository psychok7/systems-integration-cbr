package laptop;

import util.Agent;

public class Asus extends Thread {
	private Agent ba;

	public Asus(Agent ba) {
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
