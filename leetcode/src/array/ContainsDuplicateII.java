package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/1/7/0007
 * @Description:
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums==null || k ==0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length ; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                } else {
                    int tmp = i - map.get(nums[i]);
                    if (tmp <= k) {
                        return true;
                    }
                    map.put(nums[i], i);
                }
            }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums==null || k ==0)
            return false;

        for (int idx = 1; idx <= k; idx++) {

            for (int i = 0; i < nums.length - idx; i++) {
                if (nums[i] == nums[i + idx]) {
                    return true;
                }
            }
        }
        return false;
    }
}
