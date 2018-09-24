package array;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * @Author: Usher
 * @Description:
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() < num) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }

            }
        }

        return priorityQueue.peek();
    }
}
