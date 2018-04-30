package dp;

import org.omg.CORBA.MARSHAL;

/**
 * @Author: Usher
 * @Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 相邻的房子有报警器，当相邻的房子同一天被打劫时，系统自动报警
 * 在不触动报警装置的情况下，最多多少钱
 */
public class HouseRobber {
    public static int[] res;
/*
        //递归
        public int solve(int cur,int[] nums){
            if (cur < 0)
                return 0;
            //判断是否计算过
            if (res[cur] >= 0)
                return res[cur];
            res[cur] = Math.max(nums[cur] + solve(cur-2,nums),
                    solve(cur-1,nums));
            return res[cur];
        }

        public int rob(int[] nums) {
            res = new int[nums.length];

            for(int i = 0;i < nums.length;i++){
                res[i] = -1;
            }
            return solve(nums.length-1,nums);
        }*/
//dp递推
public int rob(int[] nums){
    if (nums.length == 0)
        return 0;
    if (nums.length == 1)
        return nums[0];
    res = new int[nums.length];
    res[0] = nums[0];
    res[1] = nums[0] > nums[1]?nums[0]:nums[1];
    for (int i =2;i < nums.length;i++){
        res[i] = Math.max(nums[i] + res[i - 2],
                res[i-1]);
    }
    return res[nums.length-1];
}
}
