package dp;

/**
 * @Author: Usher
 * @Description:
 *
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量.
 * 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 */
public class CoinChange {
    public int coinChange(int[] coins,int amount){
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        final int INF = Integer.MAX_VALUE;
        int dp[] = new int[amount+1];
        for (int i = 1;i <= amount;i++)
            dp[i] = INF;
        for (int i =0;i <= amount;i++){
            for (int j = 0;j < coins.length;j++){
                if (coins[j] != INF && i + coins[j] <= amount && dp[i]!= INF)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[amount] == INF ? -1:dp[amount];
    }
}
