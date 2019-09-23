package array;

/**
 * @Author: Usher
 * @Date: 2019/9/14,0014
 * @Description:
 */
public class GlobalandLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int global = 0, local = 0, n = A.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    global++;
                }
            }

            if (A[i] > A[i + 1]) {
                local++;
            }
        }
        return global == local;
    }
}
