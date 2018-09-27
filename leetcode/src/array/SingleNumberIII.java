package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
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
                list.add(key);
            }
        }

        int[] a = new int[list.size()];
        int i = 0;
        for (int num : list) {
            a[i++] = num;
        }
        return a;
    }
}
