package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int[] keep = new int[A.length];
        int[] swap = new int[A.length];

        Arrays.fill(keep,Integer.MAX_VALUE);
        Arrays.fill(swap,Integer.MAX_VALUE);
        keep[0] = 0;
        swap[0] = 1;
        for (int i=1;i < A.length;i++){
            if (A[i] > A[i-1] && B[i] > B[i-1]){
                keep[i] = keep[i - 1];
                swap[i] = swap[i-1] +1;
            }
            if (B[i] > A[i-1] && A[i] > B[i-1]){
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
                keep[i] = Math.min(keep[i], swap[i - 1]);
            }
        }
        return Math.min(keep[A.length - 1], swap[A.length - 1]);
    }
}
