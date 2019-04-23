package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Usher
 * @Date: 2019/4/17/0017
 * @Description:
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(Math.abs(nums[i] - nums[j]));
                } else {
                    priorityQueue.offer(Math.abs(nums[i] - nums[j]));

                    priorityQueue.poll();
                }
            }
        }
        return priorityQueue.poll();

    }

    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length-1] + 1];

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                arr[Math.abs(nums[i] - nums[j])]++;
            }
        }

        int count = 0;
        for(int i=0; i<arr.length; i++){
            count += arr[i];
            if(count >= k) {
                return i;
            }
        }
        return 0;
    }
}
