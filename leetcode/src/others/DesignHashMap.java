package others;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/14/0014
 * @Description:
 */
class MyHashMap {
    private int[] map;
    private final static int SIZE = 0xfffffff;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[SIZE];
        Arrays.fill(map, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key % SIZE] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        key = key % SIZE;
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key % SIZE] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
