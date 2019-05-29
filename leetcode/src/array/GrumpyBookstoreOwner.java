package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/5/27/0027
 * @Description:
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0, n = customers.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + X && i + X <= n; j++) {
                sum += customers[j];
                set.add(j);
            }

            for (int j = 0; j < n; j++) {
                if (grumpy[j] == 0 && !set.contains(j)) {
                    sum += customers[j];
                }
            }
            set.clear();

            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int res = 0, n = customers.length;

        int[] sum1 = new int[n+1];
        int[] sum2 = new int[n+1];

        for (int i = 1; i <= n; i++) {
            sum1[i] = sum1[i - 1] + customers[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            sum2[i] = sum2[i - 1] + customers[i - 1] * (grumpy[i - 1] == 0 ? 1 : 0);
        }

        int sumX , sumOther ;
        for (int i = 0; i <= n-X; i++) {
            sumX = sum1[i + X] - sum1[i];
            sumOther = sum2[i] + sum2[n] - sum2[i + X];
            res = Math.max(res, sumX + sumOther);
        }

        return res;
    }
}
