package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/6/5/0005
 * @Description:
 */
public class ThreeSumWithMultiplicity {
    private static final int m = 1_000_000_007;

    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < target - A[i]) {
                    ++j;
                } else if (A[j] + A[k] > target - A[i]) {
                    --k;
                } else {
                    if (A[j] == A[k]) {
                        res = (res + (k - j + 1) * (k - j) / 2) % m;
                        break;
                    }
                    int l = 1, r = 1;
                    while (j + l < k && A[j + l] == A[j]) {
                        ++l;
                    }
                    while (j < k - r && A[k - r] == A[k]) {
                        ++r;
                    }
                    res = (res + l * r) % m;
                    j += l;
                    k -= r;
                }
            }
        }
        return res;
    }
}
