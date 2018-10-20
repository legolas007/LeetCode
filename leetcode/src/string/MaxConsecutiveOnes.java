package string;

/**
 * @Author: Usher
 * @Description:
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                ++count;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max > count?max:count;
    }
}
