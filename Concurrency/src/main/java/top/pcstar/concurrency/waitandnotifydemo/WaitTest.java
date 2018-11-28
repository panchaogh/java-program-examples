package top.pcstar.concurrency.waitandnotifydemo;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 12:26 2018/7/26
 */
public class WaitTest {
    static public String aString="";
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");

        synchronized(t1){
            try {
                t1.start();
                System.out.println("线程t1的状态是:"+t1.isAlive());
                System.out.println("挂起主线程...");
                t1.wait();
                System.out.println("在挂起线程后面的输出");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class ThreadA extends Thread{
    public ThreadA(String name) {
        super(name);
    }
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(10000); //  使当前线阻塞 1 s，确保主程序的 wait()执行之后再执行 notify()
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName()+" call notify()");
            // 唤醒当前的wait线程
            //WaitTest.aString.notify();
        }
    }
}
