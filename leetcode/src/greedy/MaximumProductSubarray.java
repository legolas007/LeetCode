package greedy;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/15/0015
 * @Description:
 *
 * 其中f[i]表示子数组[0, i]范围内并且一定包含nums[i]数字的最大子数组乘积，g[i]表示子数组[0, i]范围内并且一定包含nums[i]数字的最小子数组乘积，初始化时f[0]和g[0]都初始化为nums[0]，其余都初始化为0。那么从数组的第二个数字开始遍历，那么此时的最大值和最小值只会在这三个数字之间产生，即f[i-1]*nums[i]，g[i-1]*nums[i]，和nums[i]。所以我们用三者中的最大值来更新f[i]，用最小值来更新g[i]，然后用f[i]来更新结果res即可
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        f[0] = nums[0];
        g[0] = nums[0];

        int res = nums[0];
        for (int i = 1;i < nums.length;i++){
            //f[i] = f[i-1] > 0 ? nums[i] + f[i-1] : nums[i];
            f[i] = Math.max(Math.max(nums[i] * f[i - 1], nums[i] * g[i - 1]), nums[i]);
            g[i] = Math.min(Math.min(nums[i] * f[i - 1], nums[i] * g[i - 1]), nums[i]);

            res = Integer.max(res, f[i]);
        }
        return res;
    }
}
