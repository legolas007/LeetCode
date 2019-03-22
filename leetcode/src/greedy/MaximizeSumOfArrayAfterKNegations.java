package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: Usher
 * @Date: 2019/3/19/0019
 * @Description:
 *
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 *
 */
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int a : A) {
            priorityQueue.add(a);
        }

        while (K-- > 0) {
            int num = priorityQueue.poll();
            priorityQueue.add(-num);
        }

        int sum = 0;
        while(!priorityQueue.isEmpty()) sum += priorityQueue.poll();

        return sum;
        //return priorityQueue.stream().mapToInt(Integer::intValue).sum();
        /*Arrays.sort(A);

        while (K-- > 0) {
            A[0] = -A[0];
            Arrays.sort(A);
        }

        return Arrays.stream(A).sum();*/
    }
}
