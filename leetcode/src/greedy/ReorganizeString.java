package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue().compareTo(a.getValue())));
        for (char c : S.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        //Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        //pq.addAll(map.entrySet());
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() > (S.length() + 1) / 2) {
                return "";
            }
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            Map.Entry<Character, Integer> entry1 = pq.remove();
            Map.Entry<Character, Integer> entry2 = pq.remove();

            sb.append(entry1.getKey());
            sb.append(entry2.getKey());
            if (entry1.getValue() - 1 > 0) {
                entry1.setValue(entry1.getValue() - 1);
                pq.add(entry1);
            }
            if (entry2.getValue() - 1 > 0) {
                entry2.setValue(entry2.getValue() - 1);
                pq.add(entry2);
            }
        }
        if (pq.size() > 0)
            sb.append(pq.peek().getKey());
        return sb.toString().length() == S.length() ? sb.toString() : "";
    }
}
