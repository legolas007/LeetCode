package dp;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];

        int max = 0;
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    } else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[i] + 1;
                        count[i] = count[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
