package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/1/2/0002
 * @Description:
 */
public class MinimumIndexSumoftwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>(Arrays.asList(list1));

        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (list.contains(list2[i])) {
                int newSum = i + list.indexOf(list2[i]);
                if (newSum < lowest) {
                    lowest = newSum;
                    map.clear();
                    map.put(list2[i], lowest);
                } else if (newSum == lowest) {
                    map.put(list2[i], lowest);
                }
            }
        }

        /*List<Map.Entry<String, Integer>> tmp = new ArrayList<>(map.entrySet());
        tmp.sort(Comparator.comparingInt(Map.Entry::getValue));

        int min = tmp.get(0).getValue();
        int count = 0;
        for (Map.Entry<String, Integer> entry : tmp) {
            if (entry.getValue() == min) {
                count++;
            } else break;
        }

        String[] res = new String[count];
        for (Map.Entry<String, Integer> entry : tmp) {
            res[count--] = entry.getKey();
            if (count == 0)
                break;
        }
        */
        String[] res = new String[map.size()];
        int i = 0;
        for (String s : map.keySet()) {
            res[i++] = s;
        }
        return res;
    }
}
