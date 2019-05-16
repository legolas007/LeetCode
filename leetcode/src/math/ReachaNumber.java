package math;

/**
 * @Author: Usher
 * @Date: 2019/5/16/0016
 * @Description:
 */
public class ReachaNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);

        int res = 0, sum = 0;
        while (sum < target || (sum - target) % 2 == 1) {
            res++;
            sum += res;
        }
        return res;
    }
}
