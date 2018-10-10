package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Description:
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int tmp = deque.pop();
                result[tmp] = i - tmp;
            }
            deque.push(i);
        }
        return result;
    }
}
