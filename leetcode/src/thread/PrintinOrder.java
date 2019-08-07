package thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: Usher
 * @Date: 2019/8/3,0003
 * @Description:
 */
public class PrintinOrder {
    private Semaphore second, third;

    public PrintinOrder() {
        second = new Semaphore(0);
        third = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        third.acquire();
        printThird.run();

    }
}
