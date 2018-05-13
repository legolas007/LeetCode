package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class BuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int sold = 0,rest = 0,hold = Integer.MIN_VALUE;

        for (int price : prices){
            int pre_sold = sold;
            sold = hold + price;
            hold = Math.max(hold,rest-price);
            rest = Math.max(rest,pre_sold);
        }
        return Math.max(rest,sold);
    }
}
