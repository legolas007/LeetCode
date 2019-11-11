package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/10/6,0006
 * @Description:
 */
public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }

        Set<Integer> set = new HashSet<>();
        for (Map.Entry entry : map.entrySet()) {
            if (!set.contains(entry.getValue())) {
                set.add((Integer) entry.getValue());
            } else return false;
        }
        return true;
    }
}
