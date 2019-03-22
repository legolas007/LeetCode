package array;

/**
 * @Author: Usher
 * @Date: 2019/3/9/0009
 * @Description:
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            maxAvg = Math.max(maxAvg, (sum * 1.0) / k);
        }
        return maxAvg;
    }
}
