package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class MaximumLengthOfRepeatesSubarray {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length +1][B.length +1];
        int res = 0;
        for (int i = 1; i < A.length+1; i++) {
            for (int j = 1; j < B.length+1; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                   // dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Integer.max(res, dp[i][j]);
            }
        }

        return dp[A.length][B.length];
    }
}
