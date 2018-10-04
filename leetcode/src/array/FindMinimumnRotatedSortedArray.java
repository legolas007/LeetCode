package array;

/**
 * @Author: Usher
 * @Description:
 */
public class FindMinimumnRotatedSortedArray {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}
