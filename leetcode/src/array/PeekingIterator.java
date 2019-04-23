package array;

import java.util.Iterator;

/**
 * @Author: Usher
 * @Date: 2019/4/16/0016
 * @Description:
 */
class PeekingIterator implements Iterator<Integer> {

    private Integer next;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.next = null;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null) {
            return -1;
        }

        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else next = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
