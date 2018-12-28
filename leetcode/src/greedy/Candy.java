package greedy;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2018/12/27/0027
 * @Description:
 */
public class Candy {
    public int candy(int[] ratings) {
        int res = 0;
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                nums[i - 1] = Integer.max(nums[i] + 1, nums[i - 1]);
            }
        }

        //return Arrays.stream(nums).sum();
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
