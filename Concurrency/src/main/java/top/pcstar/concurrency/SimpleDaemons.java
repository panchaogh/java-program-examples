package top.pcstar.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() Interrupted");
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons started");
		try {
			TimeUnit.MILLISECONDS.sleep(175);
		} catch (InterruptedException e) {
			System.out.println("sleep() Interrupted");
		}
	}
}
