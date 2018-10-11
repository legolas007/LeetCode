package greedy;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {

        int f = 0;
        int t = 0;
        for (int bill : bills) {
            if (bill == 5) {
                f++;
            } else if (bill == 10) {
               if (f == 0)
                   return false;
                f--;
                t++;
            } else if (bill == 20) {
                if (t > 0) {
                    bill -= 10;
                    t--;
                }
                int fNeed = (bill / 5) - 1;
                if (f < fNeed) {
                    return false;
                }
                f-=fNeed;
            }
        }
        return f>= 0;
    }
}
