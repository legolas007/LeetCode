package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/29/0029
 * @Description:
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }
}
