package array;


import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/5/0005
 * @Description:
 * sum is closest to target
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int newDiff = Math.abs(sum - target);
                if (diff > newDiff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    left++;
                else right--;

            }
        }
        return closest;
    }
}
