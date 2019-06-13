package math;

/**
 * @Author: Usher
 * @Date: 2019/6/7/0007
 * @Description:
 */
public class AddDigits {
    public int addDigits(int num) {

        while (num > 10) {
            num = help(num);
        }
        return num;
    }

    int help(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
