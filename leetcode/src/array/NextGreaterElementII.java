package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > nums[i]) {
                   res[i]=nums[j % n];
                    break;
                }
            }
        }

        return res;
    }
}
