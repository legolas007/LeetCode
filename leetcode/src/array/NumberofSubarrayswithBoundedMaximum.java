package array;

/**
 * @Author: Usher
 * @Date: 2019/3/9/0009
 * @Description:
 */
public class NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                result++;
            }
            int maxNum = A[i];

            for (int j = i+1; j < A.length; j++) {
                maxNum = Math.max(maxNum, A[j]);
                if (maxNum>R)
                    break;
                //<L放行，后面可能有符合条件的sub1,1,2
                if (maxNum >= L) {
                    result++;
                }
            }
        }
        return result;
    }
}