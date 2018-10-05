package array;

/**
 * @Author: Usher
 * @Description:
 */
public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int sum = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i-2 >=0 && nums[i-2] > nums[i])
                    nums[i] = nums[i - 1];
                else nums[i - 1] = nums[i];
                sum++;
                if (sum > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
