package array;

/**
 * @Author: Usher
 * @Date: 2019/3/23/0023
 * @Description:
 */
public class MyHashSet {

    private int[] data;
    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new int[1000000];
    }

    public void add(int key) {
        data[key] = 1;
    }

    public void remove(int key) {
        data[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key] == 1;
    }
}
