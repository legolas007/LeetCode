package array;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/2/23/0023
 * @Description:
 */
public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList<>();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}
