package math;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/2/6/0006
 * @Description:
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1)
            return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums[nums.length - 1] == nums.length ? nums.length : -1;
    }
}
