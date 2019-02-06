package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/2/2/0002
 * @Description:
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {

        if (A.length <=1)
            return true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                for (int j = 0; j < A.length - 1; j++) {
                    if (A[j] > A[j + 1]) {
                        return false;
                    }
                }
            } else if (A[i] > A[i + 1]) {
                for (int j = 0; j <A.length - 1; j++) {
                    if (A[j] < A[j + 1]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
