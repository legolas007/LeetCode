package dp;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/31/0031
 * @Description:
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        for(int i : days)dp[i] = -1;

        dp[0] = 0;
        for(int i=1; i<dp.length; i++){
            if(dp[i] == -1) {
                dp[i] = dp[i - 1] + costs[0];

                if (i - 7 >= 0) dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
                else dp[i] = Math.min(dp[i], costs[1]); //handle case where total days less then 7 days

                if (i - 30 >= 0) dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
                else dp[i] = Math.min(dp[i], costs[2]);
            }
            else
                dp[i] = dp[i-1];
        }
        return dp[dp.length-1];
    }
}
