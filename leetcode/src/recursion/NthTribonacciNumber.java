package recursion;

/**
 * @Author: Usher
 * @Date: 2019/8/3,0003
 * @Description:
 */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        return tribonacci(n-3) + tribonacci(n - 1) + tribonacci(n - 2);
    }

    int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 3] + f[i - 2] + f[i - 1];
        }
        return f[n];
    }
}
