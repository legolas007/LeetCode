package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 *
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int sumProfit = 0;
        for (int work : worker) {
            int min = 0;
            for (int j = 0; j < difficulty.length; j++) {
                if (difficulty[j] <= work) {
                    min = Math.max(min, profit[j]);
                }
            }
            sumProfit += min;
        }
        return sumProfit;
    }
}
