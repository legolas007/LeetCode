package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0)
            return 0;
        int max = 1;
        int cnt = 1;
        for (int i =0;i < nums.length-1;i++){

            if (nums[i+1] > nums[i]){
                cnt++;
            }else {
                   max  = Math.max(max,cnt);
                   cnt = 1;
            }
        }
        max  = Math.max(max,cnt);
        return max;
    }

    /**
     * dp
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i =1;i < nums.length;i++){

            if (nums[i] > nums[i-1]){
                f[i] = f[i-1] + 1;
            }else {
                f[i] = 1;
            }
        }

        Arrays.sort(f);
        return f[nums.length-1];
    }
}
