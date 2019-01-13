package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/13/0013
 * @Description:
 */
public class MyCircularDeque {
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    List<Integer> list = new ArrayList<>();
    int size;

    public MyCircularDeque(int k) {
        this.size = k;

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        this.list.add(value);
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;

        this.list.add(0, value);
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;

        this.list.remove(this.list.size() - 1);
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        this.list.remove(0);
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty())
            return -1;

        return this.list.get(this.list.size() - 1);
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty())
            return -1;

        return this.list.get(0);
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return this.list.size() == this.size;
    }
}
