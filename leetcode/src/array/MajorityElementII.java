package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/6/7/0007
 * @Description:
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int times = nums.length / 3;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            if (map.get(num) > times) {
                set.add(num);
            }
        }
        return new ArrayList<>(set);
    }
}
