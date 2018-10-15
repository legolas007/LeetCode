package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int minNum = nums[0];

        int sum = 0;
        for (int num : nums) {
            if (minNum == num)
                continue;
            sum += num - minNum;
        }
        return sum;
    }
}
