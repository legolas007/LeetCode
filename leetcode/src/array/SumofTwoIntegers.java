package array;

/**
 * @Author: Usher
 * @Description:
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if (a > 0) {
            for (int i = 0; i < a; i++) {
                b++;
            }
            return b;
        } else {
            for (int i = 0; i < Math.abs(a); i++) {
                b--;
            }
            return b;
        }
    }
}
