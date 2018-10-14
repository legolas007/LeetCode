package string;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        //降序排序
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> mapping : list) {
            int tmp = mapping.getValue();
            char c = mapping.getKey();
            for (int i =0;i < tmp;i++)
                sb.append(c);
        }

        return sb.toString();
    }
}
