package array;

/**
 * @Author: Usher
 * @Description:
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;

        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i-2]) {
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
    public int numberOfArithmeticSlices2(int[] A) {
        int res = 0,len = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                len++;
            } else {
                if (len > 2) {
                    res += (len - 1) * (len - 2) * 0.5;
                }
                len = 2;
            }
        }
        if (len > 2) {
            res += (len - 1) * (len - 2) * 0.5;
        }
        return res;
    }
}
