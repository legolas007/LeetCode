package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums.length <2)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1?1 : -1;
            if (sum == 0) {
                ans = i + 1;
            } else if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
