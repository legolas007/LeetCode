package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/29/0029
 * @Description:
 */
public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);

        return A;
    }
}
