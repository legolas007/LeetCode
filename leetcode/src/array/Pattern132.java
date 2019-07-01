package array;

/**
 * @Author: Usher
 * @Date: 2019/07/01,0001
 * @Description:
 * 4312
 */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums.length == 0)
            return false;
        int min_i = nums[0];//pre,min

        for (int j = 1; j < nums.length - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
