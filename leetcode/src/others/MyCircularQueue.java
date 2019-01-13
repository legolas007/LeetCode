package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/13/0013
 * @Description:
 */
public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private List<Integer> list = new ArrayList<>();
    private int size;
    public MyCircularQueue(int k) {
        this.size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.list.add(value);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.list.remove(0);
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.list.get(0);
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.list.get(this.list.size() - 1);
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.list.size() == this.size;
    }
}
