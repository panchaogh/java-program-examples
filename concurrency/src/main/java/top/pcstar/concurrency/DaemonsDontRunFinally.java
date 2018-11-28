package top.pcstar.concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally{
	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}

class ADaemon implements Runnable {
	@Override
	public void run() {
		System.out.println("Starting ADaemon");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}finally {
			System.out.println("This should always run?");
		}
	}
}
