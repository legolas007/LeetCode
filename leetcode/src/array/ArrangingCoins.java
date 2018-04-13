package array;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int lev = 1;
        while (n > 0){
            n -= lev;
            lev++;
        }
        return n == 0? lev-1:lev-2;
    }
}
