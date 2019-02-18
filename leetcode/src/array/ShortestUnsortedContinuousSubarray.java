package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/2/13/0013
 * @Description:
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);

        int begin = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                begin = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != arr[i]) {
                end = i;
                break;
            }
        }
        return end - begin;
    }
}
