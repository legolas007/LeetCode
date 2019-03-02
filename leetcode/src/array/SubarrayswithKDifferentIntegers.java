package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/2/23/0023
 * @Description:
 * 12123
 */
public class SubarrayswithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int[] cnt = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            int distCount = 0;
            Arrays.fill(cnt, 0);
            for (int j = i; j < A.length; j++) {
                if (cnt[A[j]] == 0)
                    distCount++;

                cnt[A[j]]++;
                if (distCount == K)
                    res++;
            }
        }
        return res;
    }
}
