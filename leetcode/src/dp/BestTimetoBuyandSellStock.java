package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        int[] nums = new int[prices.length+1];

        for (int i = 0;i < prices.length-1;i++)
            nums[i] = prices[i+1] - prices[i];

        return maxSubArray(nums);
    }

    private int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            //f[i] = f[i-1] > 0 ? nums[i] + f[i-1] : nums[i];
            f[i] = Math.max( nums[i] + f[i-1] , nums[i]);
        }
        Arrays.sort(f);
        return f[nums.length-1];
    }

}
