package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] res = new int[n*n];
        int i = 0;
        for (int[] a : matrix) {
            for (int num : a) {
                res[i++] = num;
            }
        }
        Arrays.sort(res);
        return res[k - 1];
    }
}
