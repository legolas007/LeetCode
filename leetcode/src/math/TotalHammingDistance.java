package math;

/**
 * @Author: Usher
 * @Description:
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num&mask)>0) {
                    count++;
                }
            }
            result += (nums.length - count) * count;
            mask <<=1;

        }
        return result;
    }


}
