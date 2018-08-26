package search;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 *
 */
public class MatchstickstoSquare {


    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;

        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0)
            return false;
        int[] sums = new int[4];
        Arrays.sort(nums);

        return helper(nums, sums, nums.length-1, sum / 4);
    }

    private boolean helper(int[] nums, int[] sums, int i, int target) {
        if (i <= 0) {
            return sums[0] == target && sums[1] == target &&sums[2] == target;
        }

        for (int j = 0; j < 4; j++) {
            if (sums[j] + nums[i] > target)
                continue;
            sums[j] += nums[i];

            if (helper(nums,sums,i-1,target))
                return true;
            sums[j] -= nums[i];
        }
        return false;
    }

}
