package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class RotateArray {
    //space O(1)
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0)
            return;
        int n = nums.length, start = 0, i = 0, cur = nums[i], cnt = 0;
        while (cnt++ < n) {
            i = (i + k) % n;
            int t = nums[i];
            nums[i] = cur;

            if (i == start) {
                start++;
                i++;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }
    //Space O(n)
    public void rotateN(int[] nums,int k) {
        int[] tmp = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = tmp[i];
        }
    }
}
