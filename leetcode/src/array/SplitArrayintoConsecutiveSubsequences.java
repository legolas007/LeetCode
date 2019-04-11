package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/4/4/0004
 * @Description:
 */
public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
            int start = entry.getKey();
            int count = 0;
            while (map.containsKey(start)) {
                count++;
                int curtCount = map.get(start);
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0)
                    map.remove(start);
                //stops when next consequtive number doesnt exist or its count smaller then curt element
                //for example: 1 2 3 4 4 5, start will stop at first 4, since 5's count is 1, smaller than 4's
                //now we have 1 2 3 4 as the first sequence, leaves 4 5 for next sequences
                if (!map.containsKey(start + 1) || (map.get(start + 1) < curtCount))
                    break;
                start++;
            }
            if (count < 3) {
                return false;
            }
        }
        return true;
    }
}
