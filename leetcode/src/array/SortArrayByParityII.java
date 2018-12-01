package array;

/**
 * @Author: Usher
 * @Description:
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {

        int[] odd = new int[A.length / 2];
        int[] even = new int[A.length / 2];

        int i = 0, j = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                even[i++] = num;
            } else odd[j++] = num;
        }

        for (i = 0, j = 0; i < A.length / 2; i++) {
            A[j++] = even[i];
            A[j++] = odd[i];
        }

        return A;
    }
}
