package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Usher
 * @Date: 2019/8/3,0003
 * @Description:
 */
public class FooBar {
    private int n;


    private int number = 1;//正在执行的线程标记

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    public FooBar(int n) {
        this.n = n;
    }

    public  void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {


            for (int i = 0; i < n; i++) {
                if (number != 1) {
                    condition1.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                number = 2;
                condition2.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public  void bar(Runnable printBar) throws InterruptedException {

        lock.lock();
        try {


            for (int i = 0; i < n; i++) {
                if (number != 2) {
                    condition2.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printBar.run();
                number = 1;
                condition1.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
