package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class TwoKeysKeyboard {

    int minSteps(int n) {
        if (n == 1) return 0;
        int res = n;
        for (int i = n - 1; i > 1; --i) {
            if (n % i == 0) {
                res = Integer.min(res, minSteps(n / i) + i);
            }
        }
        return res;
    }

    public int minSteps2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = Integer.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
