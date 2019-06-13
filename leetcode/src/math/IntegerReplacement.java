package math;

/**
 * @Author: Usher
 * @Date: 2019/6/9/0009
 * @Description:
 */
public class IntegerReplacement {
    int min = Integer.MAX_VALUE;
    public int integerReplacement(int n) {
        if (n < 1) {
            return -1;
        }
        help(n, 0);
        return min;
    }

    void help(long n, int count) {
        if (n < 1) {
            return;
        }

        if (n == 1) {
            min = Math.min(min, count);
            return;
        }

        if ((n & 1) == 0) {
            help(n >> 1, count + 1);
        } else {
            help(n + 1, count + 1);
            help(n - 1, count + 1);
        }
    }
}
