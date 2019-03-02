package array;

/**
 * @Author: Usher
 * @Date: 2019/2/23/0023
 * @Description:
 */
public class MaximumXORofwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        int maxRes = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maxRes = Integer.max(maxRes, nums[i] ^ nums[j]);
            }
        }
        return maxRes;
    }
}
