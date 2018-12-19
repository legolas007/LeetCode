package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2018/12/17/0017
 * @Description:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        if (m >= 0) System.arraycopy(nums1, 0, tmp, 0, m);
        if (n >= 0) System.arraycopy(nums2, 0, tmp, m, n);

        Arrays.sort(tmp);
        if (m + n >= 0) System.arraycopy(tmp, 0, nums1, 0, m + n);
    }
}
