package array;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @Author: Usher
 * @Date: 2019/1/10/0010
 * @Description:
 * hashSet
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        Arrays.sort(nums);

        if (nums[0] > 1) {
            return 1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] <= 0 && nums[i + 1] > 1) {
                return 1;
            }
            if (nums[i] > 0 && nums[i + 1] - nums[i] >= 2) {
                return nums[i] + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }
}
