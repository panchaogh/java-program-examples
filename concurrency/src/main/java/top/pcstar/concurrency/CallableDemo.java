package top.pcstar.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(new TaskWithResult(i));
			list.add(future);
		}
		for (Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e);
				if (e instanceof InterruptedException) {
					return;
				}
			}finally {
				executorService.shutdown();
			}
		}
	}
}

class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id + "------------" + Thread.currentThread();
	}
	
}
