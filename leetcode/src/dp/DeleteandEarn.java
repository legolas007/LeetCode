package dp;

/**
 * @Author: Usher
 * @Description:
 * [3,4,2]->[0 2 3 4]
 * [ 2 2 3 3 3 4]->[0 2*2 3*3 4]
 */
public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0)
            return 0;

        int r =0;
        for (int num : nums)
            r = Math.max(r, num);
        int[] points = new int[r + 1];

        for (int num : nums)
            points[num] += num;

        return rob(points);
    }

    private int rob(int[] nums){

        if (nums.length == 1)
            return nums[0];

        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);

        for (int i = 2;i < nums.length;i++){
            res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
        }
        return res[nums.length - 1];
    }
}
