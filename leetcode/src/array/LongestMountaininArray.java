package array;

/**
 * @Author: Usher
 * @Date: 2019/6/3/0003
 * @Description:
 */
public class LongestMountaininArray {
    public int longestMountain(int[] A) {

        int n = A.length, res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int left = i - 1, right = i + 1;
                while (left > 0 && A[left] > A[left - 1]) {
                    left--;
                }

                while (right < n - 1 && A[right] > A[right + 1]) {
                    right++;
                }

                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }
}
