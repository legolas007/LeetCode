package math;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

/**
 * @Author: Usher
 * @Description:
 */
class LRUCache {
    private LinkedHashMap<Integer,Integer> map;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if(value != -1){
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}