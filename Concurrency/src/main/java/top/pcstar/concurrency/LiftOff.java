package top.pcstar.concurrency;

public class LiftOff implements Runnable{
	private boolean isRun = false;
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff() {
	}
	public LiftOff(int countDown) {
		super();
		this.countDown = countDown;
	}
	public String status() {
		return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+"),";
	}
	public void run() {
		isRun = true;
		while(isRun) {
			countDown--;
			System.out.print(status());
			Thread.yield();//让当前线程回到就绪状态
			if (countDown == 0) {
				isRun = false;
			}
		}
	}
	
}
