package array;

/**
 * @Author: Usher
 * @Date: 2019/7/20,0020
 * @Description:
 */
public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {

        //two sum
        for (int i = 0; i <= Math.sqrt(c); i++) {
            double j = Math.sqrt(c - i * i);
            if (j == (int) j) {
                return true;
            }
        }
        return false;
    }
}
