package laptop;

import util.Agent;

	public class Apple extends Thread {
		Agent ba;
		public Apple(Agent ba) {
			this.ba = ba;
		}
		public void run() {
			try {
				String res = ba.receive("/queue/Pong");
				System.out.println("Pong got: " + res);
				ba.send("/queue/Ping","HelloPing,Pong");
				ba.finish();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}