package top.pcstar.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁的一般结构
 * @author PANCHAO
 *
 */
public class ReentrantLockConstruction {
	public void lockMethod() {
		ReentrantLock reentrantLock = new ReentrantLock();
		reentrantLock.lock();
		try {
			System.out.println("受保护的代码段");
		} finally {
			System.out.println("发生异常时可以保证释放锁，避免出现死锁的发生");
			reentrantLock.unlock();
		}
	}
}
