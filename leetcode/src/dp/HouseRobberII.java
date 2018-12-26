package dp;

/**
 * @Author: Usher
 * @Date: 2018/12/25/0025
 * @Description: House[0]-House[n-2] or House[1]-House[n-1]
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] res1 = new int[nums.length];
        int[] res2 = new int[nums.length];
        res1[0] = nums[0];
        res1[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            res1[i] = Math.max(nums[i] + res1[i - 2],
                    res1[i - 1]);
        }
        res2[0] = 0;
        res2[1] = nums[1];
        res2[2] = nums[1] > nums[2] ? nums[1] : nums[2];
        for (int i = 3; i < nums.length; i++) {
            res2[i] = Math.max(nums[i] + res2[i - 2],
                    res2[i - 1]);
        }
        return res1[nums.length - 2] > res2[nums.length - 1] ? res1[nums.length - 2] : res2[nums.length - 1];
    }
}
