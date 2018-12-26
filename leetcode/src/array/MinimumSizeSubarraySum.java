package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2018/12/25/0025
 * @Description:
 * two pointers,binary search
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, len = nums.length, res = len + 1;
        while (right < len) {
            while (sum < s && right < len) {
                sum += nums[right++];
            }
            while (sum >= s) {
                res = Integer.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == len + 1 ? 0 : res;
    }
}
