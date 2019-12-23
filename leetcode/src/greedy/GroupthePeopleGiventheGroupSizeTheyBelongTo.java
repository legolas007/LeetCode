package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/12/14,0014
 * @Description:
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.put(i, groupSizes[i]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey() - o1.getKey();
            }
            return o2.getValue() - o1.getValue();
        });

        List<Integer> curList;

        int value;
        for (int i = 0; i < list.size(); i += value) {
            value = list.get(i).getValue();
            curList = new ArrayList<>();
            for (int j = 0; j < value; j++) {
                curList.add(list.get(i + j).getKey());
            }

            res.add(curList);
        }
        return res;
    }
}
