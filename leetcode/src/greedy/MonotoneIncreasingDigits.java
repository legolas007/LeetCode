package greedy;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/17/0017
 * @Description:
 *
 * 332，我们发现最后一位2小于之前的3，那么此时我们将前面位减1，先变成322，再往前看，还是小于前面的3，那么我们再将前面位减1，就变成了222，此时222不是最大的单调递增数，我们可以将后面两位变成9，于是乎就有了299，小于给定的332，符合题意。如果给定的数字是232，那么就会得到229，我们可以发现规律，要找到从后往前遍历的最后一个值升高的位置，让前一位减1，并把当前位以及后面的所有位都变成9
 *
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();

        int j = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] >= chars[i - 1]) {
                continue;
            }
            chars[i - 1]--;
            j = i;
        }

        for (int i = j; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.valueOf(String.valueOf(chars));
    }

}
