package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
