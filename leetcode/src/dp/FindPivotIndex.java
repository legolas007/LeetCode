package dp;

/**
 * @Author: Usher
 * @Description:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        int sum = 0;
        for (int num : nums)
            sum += num;
        int l=0,r= sum;
        for (int i =0;i < nums.length;i++){
            r -= nums[i];
            if (l == r)
                return i;
            l += nums[i];
        }
        return -1;
    }
}
