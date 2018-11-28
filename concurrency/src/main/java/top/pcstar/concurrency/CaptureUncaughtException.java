package top.pcstar.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class ExceptionThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException("线程中捕获异常练习!");
	}

}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
	public static String str = "";
	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) {
		System.out.println("---------------------------------------");
		str = arg1.getMessage();
		System.out.println("---"+arg1.getMessage()+"---");
		System.out.println("---------------------------------------");
	}
}

class HandlerThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		return t;
	}
	
}

public class CaptureUncaughtException{
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
		executorService.execute(new ExceptionThread());
		executorService.shutdown();
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(MyUncaughtExceptionHandler.str);
	}
}
