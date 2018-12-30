package math;

/**
 * @Author: Usher
 * @Date: 2018/12/30/0030
 * @Description:
 * n=0,1 (0)
 * n=1,1 + 9 (0...9)
 * n=2,1 + 9 + (9 * 8 + 9 * 1)
 * dp[i] = dp[i - 1] + 9 * A(9, n - 1).
 */
public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int count = 9;
            for (int j = 0; j < i - 1; j++) {
                count *= (9 - j);
            }
            dp[i] = dp[i - 1] + count;
        }
        return dp[n];
    }
}
