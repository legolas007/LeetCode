package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class MinCostClimbingStairs {
    //递归
    public int minCostClimbingStairs2(int[] cost) {
        int[] m = new int[cost.length + 1];

        return dp(cost, m, cost.length);
    }
    private int dp(int[] cost,int[] m, int i){
        if (i <= 1)
            return 0;
        if (m[i] > 0)
            return m[i];
        return m[i] = Math.min(dp(cost, m, i - 1) + cost[i - 1],
                dp(cost, m, i - 2) + cost[i - 2]);
    }


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
