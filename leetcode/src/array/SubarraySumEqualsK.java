package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int subarraySum2(int[] nums, int k) {
        int res = 0, sum = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.merge(sum, 1, Integer::sum);
        }
        return res;
    }
}
