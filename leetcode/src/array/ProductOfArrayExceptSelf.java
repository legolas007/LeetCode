package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                ++cnt;
                continue;
            }
            product *= num;

        }

        if (cnt >= 2) {
            Arrays.fill(nums, 0);
            return nums;
        } else if (cnt == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = product;
                } else
                    nums[i] = 0;
            }
            return nums;
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
            return nums;
        }

    }
}
