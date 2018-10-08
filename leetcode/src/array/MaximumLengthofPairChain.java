package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @Author: Usher
 * @Description:
 */
public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        Deque<int[]> deque = new ArrayDeque<>();
        for (int[] pair : pairs) {
            if (deque.isEmpty()) {
                deque.push(pair);
            } else {
                int[] tmp = deque.peek();
                if (pair[0] > tmp[1])
                    deque.push(pair);
            }
        }
        return deque.size();
    }
}
