package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int minNum = A[0];
        int maxNum = A[A.length - 1];

        return 2*K >= maxNum-minNum ? 0 : maxNum-minNum-2*K;
    }
}
