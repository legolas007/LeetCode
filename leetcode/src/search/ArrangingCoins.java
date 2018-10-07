package search;

/**
 * @Author: Usher
 * @Description:
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int level = 1;
        while (n > 0) {
            n -= level;
            level++;
        }
        return n == 0 ? level - 1 : level - 2;
    }
}
