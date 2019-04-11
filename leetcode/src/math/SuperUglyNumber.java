package math;

/**
 * @Author: Usher
 * @Date: 2019/4/11/0011
 * @Description:
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] dp = new int[n];
        dp[0] = 1;

        int[] idx = new int[primes.length];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[idx[j]] * primes[j]);
            }

            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[idx[j]] * primes[j]) {
                    ++idx[j];
                }
            }
        }
        return dp[n - 1];
    }
}
