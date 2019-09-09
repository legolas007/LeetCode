package dp;

/**
 * @Author: Usher
 * @Date: 2019/8/17,0017
 * @Description:
 */
public class NumberofDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        int mod = 1000000000 + 7;

        dp[0][0] = 1;

        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= f; j++) {
                for (int k = j; k <= target; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % mod;
                }
            }
        }
        return dp[d][target];
    }
}
