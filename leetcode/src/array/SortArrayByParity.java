package array;

/**
 * @Author: Usher
 * @Description:
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[cur++] = A[i];
                A[i] = -1;
            }
        }
        for (int num : A) {
            if (num != -1) {
                res[cur++] = num;
            }
        }
        return res;
    }
}
