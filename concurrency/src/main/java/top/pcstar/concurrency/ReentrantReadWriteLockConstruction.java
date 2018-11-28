package top.pcstar.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁的一般结构
 * @author PANCHAO
 *
 */
public class ReentrantReadWriteLockConstruction {
	static Map<String, Object> map = new HashMap<>();
	static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	static ReadLock readLock = lock.readLock();
	static WriteLock writeLock = lock.writeLock();
	//获取一个key对应的值
	public static final Object get(String key) {
		try {
			readLock.lock();
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}
	//设置key对应的value,并返回旧value
	public static final Object set(String key,Object value) {
		try {
			writeLock.lock();
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	//清空所有的内容
	public static final void clear() {
		try {
			writeLock.lock();
			map.clear();
		} finally {
			writeLock.unlock();
		}
	}
}
