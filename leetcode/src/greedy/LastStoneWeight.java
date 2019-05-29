package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/5/24/0024
 * @Description:
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }

        while (!priorityQueue.isEmpty()){
            if (priorityQueue.size() == 1) {
                return priorityQueue.peek();
            }
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();

            if (x != y) {
                priorityQueue.add(Math.abs(y - x));
            }
        }
        return 0;
    }
}
