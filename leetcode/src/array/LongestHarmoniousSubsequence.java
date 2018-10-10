package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (Integer k : map.keySet()) {
            if (map.containsKey(k + 1)) {
                res = Math.max(res, map.get(k) + map.get(k + 1));
            }
        }
        /*for (Map.Entry entry : map.entrySet()) {
            int tmp = (int)entry.getKey()+1;
            if (map.containsKey(tmp)) {
                res = Math.max(res, map.get(entry.getKey()) + map.get(tmp));
            }
        }*/
        return res;
    }
}
