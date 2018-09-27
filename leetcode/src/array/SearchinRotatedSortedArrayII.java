package array;

/**
 * @Author: Usher
 * @Description:
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {

        for (int num : nums) {
            if (target == num) {
                return true;
            }
        }
        return false;
    }
}
