package array;

/**
 * @Author: Usher
 * @Date: 2019/4/2/0002
 * @Description:
 */
public class FibonacciNumber {
    public int fib(int N) {
        if (N == 0)
            return 0;

        if (N==1)
            return 1;

        return fib(N - 1) + fib(N - 2);
    }
}
