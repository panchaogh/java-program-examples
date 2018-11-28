package top.pcstar.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition条件练习
 * @author PANCHAO
 *
 */
public class ConditionTest {
	final Lock lock = new ReentrantLock();
	final Condition condition = lock.newCondition();
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ConditionTest conditionTest = new ConditionTest();
		Productor productor = conditionTest.new Productor();
		Consumer consumer = conditionTest.new Consumer();
		executorService.execute(consumer);
		executorService.execute(productor);
		executorService.shutdown();
	}
	
	//生产者
	class Productor implements Runnable{

		@Override
		public void run() {
			produce();
		}
		
		private void produce() {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				lock.lock();
				System.out.println("我拿到一个锁："+Thread.currentThread().getName());
				condition.signalAll();
			} finally {
				System.out.println("我生产一个信号："+Thread.currentThread().getName());
				lock.unlock();
			}
		}
		
	}
	//消费者
	class Consumer implements Runnable{

		@Override
		public void run() {
			consume();
		}
		
		private void consume() {
			try {
				lock.lock();
				System.out.println("我在等待一个产品："+Thread.currentThread().getName());
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				System.out.println("拿到一个产品："+Thread.currentThread().getName());
				lock.unlock();
			}
		}
	}
}
