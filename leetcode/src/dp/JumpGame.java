package dp;

/**
 * @Author: Usher
 * @Description:
 * dp[i]表示达到i位置时剩余的步数，当前位置的剩余步数（dp值）和当前位置的跳力中的较大那个数决定了当前能到的最远距离，而下一个位置的剩余步数（dp值）就等于当前的这个较大值减去1，
 * 因为需要花一个跳力到达下一个位置，状态转移方程了：dp[i] = max(dp[i - 1], nums[i - 1]) - 1，如果当某一个时刻dp数组的值为负了，说明无法抵达当前位置，则直接返回false
 *
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1])-1;
            if (dp[i] < 0)
                return false;
        }
        return dp[nums.length - 1] >= 0;
    }
}
