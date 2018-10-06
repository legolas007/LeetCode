package search;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * dp[i]表示正整数i最少能由多个完全平方数组成
 */
public class PerfectSquares {
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
