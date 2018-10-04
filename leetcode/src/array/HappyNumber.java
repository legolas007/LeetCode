package array;

/**
 * @Author: Usher
 * @Description:
 * 非快乐数有个特点，循环的数字中必定会有4
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int tmp = 0;
            while (n != 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = tmp;
        }
        return n == 1;
    }

}
