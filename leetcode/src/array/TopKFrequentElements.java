package array;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int cnt = 0;
        for (Map.Entry<Integer,Integer> entry : list) {
            if (cnt >= k) {
                break;
            }
            result.add(entry.getKey());
            cnt++;

        }
        return result;
    }
}
