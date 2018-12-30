package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2018/12/29/0029
 * @Description:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 *
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 */
public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> (o.getValue() + o.getKey())));

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                //list.add(new AbstractMap.SimpleEntry<>(num1, num2));
                queue.add(new AbstractMap.SimpleEntry<>(num1, num2));
            }
        }
        //list.sort(Comparator.comparingInt(o -> (o.getValue() + o.getKey())));

        List<int[]> res = new ArrayList<>();
        //for (Map.Entry entry : queue) {
        /*for (Map.Entry entry : list) {
            if (res.size()==k)
                break;
            res.add(new int[]{(int) entry.getKey(), (int) entry.getValue()});
        }*/
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty())
                break;
            Map.Entry<Integer,Integer> entry =queue.poll();
            res.add(new int[]{entry.getKey(), entry.getValue()});
        }

        return res;
    }

    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                q.add(new int[] {n1, n2});
            }
        }

        List<int[]> ret = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (q.isEmpty()) break;
            ret.add(q.poll());
        }
        return ret;
    }
}
