package array;

/**
 * @Author: Usher
 * @Date: 2019/4/23/0023
 * @Description:
 */
public class MaximumSumofTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int N = A.length;
        int[] sums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        int sumL, sum = 0;
        for (int i = 0; i < N + 1 - L; ++i) {
            sumL = sums[i + L] - sums[i];
            for (int j = 0; j < N + 1 - M; ++j) {
                if (j + M <= i || i + L <= j) {
                    int sumM = sums[j + M] - sums[j];
                    if (sumM + sumL > sum) {
                        sum = sumM + sumL;
                    }
                }
            }
        }
        return sum;
    }

    public int maxSumTwoNoOverlap2(int[] A, int L, int M) {
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; ++i) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        return Math.max(getMax(preSum, L, M), getMax(preSum, M, L));
    }

    private int getMax(int[] p, int L, int M) {
        int result = 0;
        int maxL = 0;
        for (int i = L + M; i < p.length; ++i) {
            maxL = Math.max(maxL, p[i - M] - p[i - M - L]);
            result = Math.max(result, maxL + p[i] - p[i - M]);
        }
        return result;
    }
}
