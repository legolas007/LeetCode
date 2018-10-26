package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length % 2 == 0 ? (nums.length + 1) / 2 : nums.length / 2;
        int res = 0;
        for (int num : nums) {
            res += Math.abs(nums[mid] - num);
        }
        return res;
    }
}
