package array;

/**
 * @Author: Usher
 * @Description:
 */
public class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        } else return nums[0];
    }
}
