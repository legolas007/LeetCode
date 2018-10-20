package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        if (nums.length >0)
            res[map.get(nums[nums.length-1])] = "Gold Medal";
        if (nums.length > 1)
            res[map.get(nums[nums.length-2])]= "Silver Medal";
        if (nums.length > 2)
            res[map.get(nums[nums.length-3])]= "Bronze Medal";

        for (int i = nums.length - 4, j = 4; i >= 0; i--) {
            res[map.get(nums[i])] = String.valueOf(j++);
        }
        return res;
    }
}
