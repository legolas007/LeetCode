package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * cost[i]表示从起点src出发到i经过最多K次最短距离，采用松弛法，当经过第k个阶段时，每当有更小的距离时，则更新。
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int inf = 0x3f3f3f3f;
        int[] cost = new int[n];
        Arrays.fill(cost, inf);
        cost[src] = 0;

        int ans = cost[dst];
        for (int i =0;i <=K;i++){
            int[] tmp = new int[n];
            Arrays.fill(tmp,inf);
           for (int[] f: flights){
               tmp[f[1]] = Math.min(tmp[f[1]], cost[f[0]] + f[2]);
           }
           cost = tmp;
           ans = Math.min(ans,cost[dst]);
        }
        if (ans>= inf)return -1;
        else return ans;
    }
}
