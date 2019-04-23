package math;

/**
 * @Author: Usher
 * @Date: 2019/4/20/0020
 * @Description:
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {

        if (A.length == 0) {
            return 0;
        }
        int maxRes = Integer.MIN_VALUE;
        int[] origin = A.clone();
        for (int i = 0; i < A.length; i++) {
            rotateN(A, i);
            int childRes = 0;

            for (int j = 0; j < A.length; j++) {
                childRes += j * A[j];
            }
            maxRes = Math.max(maxRes, childRes);
            A = origin.clone();
        }
        return maxRes;
    }

    private void rotateN(int[] nums, int k) {
        int[] tmp = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = tmp[i];
        }
    }

    /**
     * F0 = 0 + 1a1 + 2a2 + 3a3
     *
     * F1 = F0 + a0 + a1 + a2 - 3a3 = F0 + a0 + a1 + a2 + a3 - 4a3
     *
     * F2 = F1 + a3 + a0 + a1 - 3a2 = F1 + a0 + a1 + a2 + a3 - 4a2
     *
     * F3 = F2 + a2 + a3 + a0 - 3a1 = F2 + a0 + a1 + a2 + a3 - 4a1
     * @param A
     * @return
     */
    public int maxRotateFunction2(int[] A) {
        int F = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        int n = A.length;
        if( n <= 1) return 0;
        for( int i = 0; i < n; i++){
            F += i*A[i];
            sum += A[i];
        }
        if( F > res) res = F;
        for(int k = 1; k < n; k++){
            F += sum;
            F -= n*A[n-k];
            if(F > res) res = F;
        }
        return res;
    }
}
