package top.pcstar.concurrency;

public class Daemon implements Runnable{
	private Thread[] t = new Thread[10];
	@SuppressWarnings("unused")
	@Override
	public void run() {
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DeamonSpawn());
			t[i].start();
			System.out.print("DeamonSpawn"+i+"started, ");
		}
		for (int i = 0; i < t.length; i++) {
			System.out.println("t["+i+"].isDaemon()="+t[i].isDaemon()+", ");
			while(true) {
				Thread.yield();
			}
		}
	}

}

class DeamonSpawn implements Runnable {
	@Override
	public void run() {
		while(true){
			Thread.yield();
		}
	}
}
