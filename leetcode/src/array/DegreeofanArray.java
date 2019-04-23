package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/4/12/0012
 * @Description:
 */
public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length, maxDegree = 0;
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
            maxDegree = Math.max(maxDegree, map.get(nums[i]));
        }

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxDegree) {

                int start = Integer.MAX_VALUE, end = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (nums[i] == entry.getKey() && start == Integer.MAX_VALUE) {
                        start = i;
                        end = i;
                    } else if (nums[i] == entry.getKey() && start != Integer.MAX_VALUE) {
                        end = i;
                    }
                }

                res = Math.min(res, end - start+1);
            }

        }
        return res;
    }
}
