package math;

/**
 * @Author: Usher
 * @Date: 2019/6/7/0007
 * @Description:
 * 2 3 5 7
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 1; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        for (int i = sqrt + 1; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
