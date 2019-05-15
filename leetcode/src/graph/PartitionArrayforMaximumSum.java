package graph;

/**
 * @Author: Usher
 * @Date: 2019/5/15/0015
 * @Description:
 */
public class PartitionArrayforMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int curMax = 0;

            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                curMax = Math.max(curMax, A[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + curMax * j);
            }
        }
        return dp[n - 1];
    }
}
