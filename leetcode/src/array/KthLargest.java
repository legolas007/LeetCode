package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Usher
 * @Date: 2019/3/2/0002
 * @Description:
 */
public class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;
    //删除对头最小的数，前k个最大数，从小到大排列，最后对头就是第k个
    public KthLargest(int k, int[] nums) {
        for (Integer num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
