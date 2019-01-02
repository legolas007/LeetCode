package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/1/1
 * @Description:
 *
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 *
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1 - x) == Math.abs(o2 - x) && !o1.equals(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1 - x) - Math.abs(o2 - x);
        });

        for (int num : arr) {
            priorityQueue.add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
            if (res.size() == k) {
                break;
            }
        }
        Collections.sort(res);
        return res;
    }


    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = arr.length - k;
        while(start < end) {
            int mid = (end - start) / 2 + start;
            if(2 * x > arr[mid + k] + arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        for(int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
