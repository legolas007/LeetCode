package search;

/**
 * @Author: Usher
 * @Date: 2019/1/19/0019
 * @Description:
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target) {
                right = mid-1;
            } else left=mid+1;
        }
        return -1;
    }
}
