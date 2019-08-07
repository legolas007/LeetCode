package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
class ZeroEvenOdd {
    private int n;

    private int flag=0;
    private ReentrantLock reentrantLock=new ReentrantLock();
    Condition printedZeroEven=reentrantLock.newCondition();
    Condition printedZeroOdd=reentrantLock.newCondition();
    Condition printedNumber=reentrantLock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            reentrantLock.lock();
            while(flag!=0){
                printedNumber.await();
            }
            printNumber.accept(0);
            if((i & 1)==0){
                flag=2;
                printedZeroEven.signalAll();
            }else {
                flag=1;
                printedZeroOdd.signalAll();
            }
            reentrantLock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            reentrantLock.lock();
            while(flag==0 || flag==1){
                printedZeroEven.await();
            }
            printNumber.accept(i);
            flag=0;
            printedNumber.signalAll();
            reentrantLock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            reentrantLock.lock();
            while(flag==0 || flag==2){
                printedZeroOdd.await();
            }
            flag=0;
            printNumber.accept(i);
            printedNumber.signalAll();
            reentrantLock.unlock();
        }
    }
}