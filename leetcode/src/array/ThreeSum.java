package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            // skip same result
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1, end = nums.length - 1, sum = 0, target = 0 - nums[i];
            while (start < end) {
                sum = nums[start] + nums[end];
                if (target == sum) {
                    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //skip same result
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return lists;
    }
}
