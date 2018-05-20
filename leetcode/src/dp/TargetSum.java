package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Usher
 * @Description:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 */
public class TargetSum {
    //dfs
    private int cnt = 0;
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums == null)
            return 0;
        dfs(nums, S, 0, 0);
        return cnt;
    }

    private void dfs(int[] nums, int s,int k ,int sum){
        //所有元素用完了
        if (k == nums.length){
            if (s == sum)
                cnt++;
            return;
        }

        //下一个元素
        dfs(nums,s,k+1,sum+nums[k]);
        dfs(nums,s,k+1,sum-nums[k]);
    }
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }

}
