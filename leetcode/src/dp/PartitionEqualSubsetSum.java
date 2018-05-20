package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * 将问题转化为背包问题，即取前I个数（物品），和体积j下，dp[i][j]的最大值
 * dp[i][j]=max{ dp[i-1][j], dp[i-1][j-nums[i]]+nums[i] }。
 * dp[n][sum/2] 如果等于sum/2 就证明用了这n个数下，正好能加出一个sum/2
 */
public class PartitionEqualSubsetSum {
    //一维
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;
        //dp[i]数字i是否是原数组的任一个子集合之和
        int[] dp = new int[sum + 1];

        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= 0; i--)
                if (dp[i] != 0)
                    dp[i + num] = 1;
            if (dp[sum >> 1] != 0)
                return true;
        }
        return false;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        sum /=2;
        int n=nums.length;
        // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
        int dp[][]=new int[n][sum + 1];
        // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
        for(int i=nums[0];i<=sum;i++){
            dp[0][i] = nums[0];
        }
        //遍历n个数字，即视为n个产品
        for(int i=1;i<n;i++){
            //加入了这种物品后更新状态
            for(int j=nums[i];j<=sum;j++){
                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
            }
        }
        //放满了才能表示正好1/2
        if(dp[n-1][sum]==sum)
            return true;
        else
            return false;
    }
}
