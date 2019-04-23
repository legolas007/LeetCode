package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/4/23/0023
 * @Description:
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, Comparator.comparingInt(a -> (a[1] - a[0])));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0];
        }
        return cost;
    }

    int twoCitySchedCost2(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }

    public int twoCitySchedCost3(int[][] costs) {
        int baseCase = 0; // all the people choose city A

        for(int i = 0; i <= costs.length - 1; i++) {
            baseCase += costs[i][0];
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] cost : costs) {
            int diff = cost[0] - cost[1];
            pq.offer(diff);
        }

        int n = costs.length / 2;

        for(int i = 0; i <= n - 1; i++) {
            int diff = pq.poll();

            baseCase = baseCase + ((-1) * diff);
        }

        return baseCase;
    }
}
