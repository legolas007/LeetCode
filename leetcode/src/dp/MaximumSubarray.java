package dp;


import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
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
