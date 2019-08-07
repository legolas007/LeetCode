package array;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Usher
 * @Date: 2019/7/20,0020
 * @Description:
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        int[] res = new int[A.length];

        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            int max = Integer.MIN_VALUE, k = Integer.MIN_VALUE;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    if (A[j] > max) {
                        max = A[j];
                        k = j;
                    }
                }
            }
            if (max != Integer.MIN_VALUE) {
                int tmp = A[i];
                A[i] = A[k];
                A[k] = tmp;
                System.arraycopy(A, 0, res, 0, A.length);
                tmp = A[i];
                A[i] = A[k];
                A[k] = tmp;
                flag = true;
            }
        }
        return flag ? res : A;
    }
}
