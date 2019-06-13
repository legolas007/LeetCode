package math;

/**
 * @Author: Usher
 * @Date: 2019/6/9/0009
 * @Description:
 */
public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if (num == 0)
            return false;
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }
}
