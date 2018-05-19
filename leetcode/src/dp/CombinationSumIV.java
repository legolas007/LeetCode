package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 */
public class CombinationSumIV {
/*    //递归
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target+1];
        Arrays.fill(f,-1);
        //target = 0
        f[0] = 1;
        return dp(nums,target,f);
    }
    private int dp(int[] nums,int target,int[] f){
        if (target < 0)
            return 0;
        //记忆化
        if (f[target] != -1)
            return f[target];

        int ans = 0;
        for (int num : nums)
            ans += dp(nums,target-num,f);
        //记住当前解
        return f[target] = ans;
    }*/
//递推
public int combinationSum4(int[] nums, int target) {
    int[] f = new int[target+1];
    Arrays.fill(f,0);
    //target = 0
    f[0] = 1;

    for (int i =1;i <= target;i++)
        for (int num : nums)
            if (i - num >= 0)
                f[i] += f[i-num];
    return f[target];
}

}
