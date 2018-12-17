package array;

/**
 * @Author: Usher
 * @Description:
 * two pointer
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int i, j;
        for (i=1, j=1; j < nums.length; j++) {
            if (nums[j-1] == nums[j]) {
                cnt++;
            } else {
                cnt=1;
            }
            if (cnt <= 2) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
