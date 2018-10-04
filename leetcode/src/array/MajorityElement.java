package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (a, b) -> a + b);
            if (map.get(num) > nums.length / 2)
                return num;
        }
        return 0;
    }
}
