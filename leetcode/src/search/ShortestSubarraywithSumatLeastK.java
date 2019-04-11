package search;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Date: 2019/3/23/0023
 * @Description:
 */
public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray2(int[] A, int K) {
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < A.length; k++) {
            int sum = 0;
            for (int i = k; i < A.length; i++) {
                sum += A[i];

                if (sum >= K) {
                    res = Math.min(res, i -k+1);
                    break;
                }
            }
        }


        return res==Integer.MAX_VALUE?-1:res;
    }

    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] sums = new int[A.length + 1];
        //sum,
        for (int i = 1; i <= A.length; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && (sums[i] - sums[deque.getFirst()]) >= K) {
                res = Math.min(res, i - deque.getFirst());
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
