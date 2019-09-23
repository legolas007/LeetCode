package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/9/14,0014
 * @Description:
 */
public class MaximumSubarraySumwithOneDeletion {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return arr[0];
        }
        int result = Integer.MIN_VALUE;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = arr[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(arr[i], left[i-1]+arr[i]);
            result = Math.max(result, left[i]);
        }
        right[len-1] = arr[len-1];
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i+1]+arr[i]);
        }

        for (int i = 1; i < len-1; i++) {
            result = Math.max(left[i-1] + right[i+1], result);
        }
        return result;
    }
}
