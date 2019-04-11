package array;

/**
 * @Author: Usher
 * @Date: 2019/4/4/0004
 * @Description:
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {

        int cnt = 0, res = 0;
        for (int i=0,j=0; i < A.length; i++) {
            while (cnt >K) {
                if (A[j++] == 0) {
                    cnt--;
                }

            }
            if (A[i] == 0) {
                cnt++;
            }
            if (cnt == K) {
                res = Math.max(res, i - j+1);
            }
        }

        if (cnt < K) {
            return A.length;
        }
        return res;
    }
}
