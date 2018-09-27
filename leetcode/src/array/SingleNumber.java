package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int key = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                key = (int)entry.getKey();
                break;
            }
        }
        return key;
    }
}
