package others;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: Usher
 * @Description:
 */
public class MapSum {
    /**
     * Initialize your data structure here.
     */
    Map<String, Integer> map ;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
         map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getKey();
            if (s.startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }
}
