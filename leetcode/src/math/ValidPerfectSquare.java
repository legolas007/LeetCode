package math;

/**
 * @Author: Usher
 * @Description:
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int tmp = (int) Math.sqrt(num);
        return tmp * tmp == num;
    }
}
