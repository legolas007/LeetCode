package array;

/**
 * @Author: Usher
 * @Date: 2019/4/12/0012
 * @Description:
 */
public class RLEIterator {
    private int index;
    int[] A;

    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        while (index < A.length && n > A[index]) {
            n = n - A[index];
            index += 2;
        }

        if (index >= A.length) {
            return -1;
        }

        A[index] -= n;
        return A[index + 1];
    }
}
