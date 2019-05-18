package array;

import java.util.PriorityQueue;

/**
 * @Author: Usher
 * @Date: 2019/5/18/0018
 * @Description:
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {

            if (priorityQueue.contains(nums[i])) {
                continue;
            }
            if (priorityQueue.size() < 3 ) {
                priorityQueue.offer(nums[i]);
            } else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }

        if (priorityQueue.size() >= 3) {
            return priorityQueue.peek();
        } else if (priorityQueue.size() == 2) {
            priorityQueue.poll();
            return priorityQueue.peek();
        }
        return priorityQueue.peek();
    }
}
