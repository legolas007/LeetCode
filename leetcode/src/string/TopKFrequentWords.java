package string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Usher
 * @Description:
 * HashMap priorityQueue
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.merge(word, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        //list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        List<String> res = new ArrayList<>();
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (cnt++ == k) {
                break;
            }
            res.add(entry.getKey());
        }
        return res;
    }
}
