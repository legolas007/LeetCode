package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/06/30,0030
 * @Description:
 */
public class KthSmallestinLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        String[] Strings = new String[n];

        for (int i = 1; i <= n; i++) {
            Strings[i - 1] = String.valueOf(i);
        }

        Arrays.sort(Strings);
        return Integer.valueOf(Strings[k - 1]);
    }

    public int findKthNumber2(int n, int k) {
        int cur = 1;
        --k;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min((long) n + 1, last) - first;
                first *= 10;
                last *= 10;
            }

            if (step <= k) {
                ++cur;
                k -= step;
            } else {
                cur *= 10;
                --k;
            }
        }
        return cur;
    }
}
