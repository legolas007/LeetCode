package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Usher
 * @Date: 2019/2/23/0023
 * @Description:
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        Arrays.stream(nums).forEach(queue::add);
        int maxNum = queue.peek();
        int res = 1;
        res *= queue.poll();
        res *= queue.poll();
        res *= queue.poll();

        int res2 = 1;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        Arrays.stream(nums).forEach(queue::add);
        res2 *= queue1.poll();
        res2 *= queue1.poll();
        res2 *= maxNum;
        return Math.max(res, res2);
    }

    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int p2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(p1, p2);
    }

}
