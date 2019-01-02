package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2018/12/31/0031
 * @Description: Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        Map<Interval, Integer> map = new HashMap<>();
        int i = 0;
        for (Interval interval : intervals) {
            map.put(interval, i++);
        }

        int[] res = new int[intervals.length];
        List<Map.Entry<Interval, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(o -> o.getKey().start));

        for (int j = 0; j < list.size() - 1; j++) {

            boolean flag = false;

            for (int k = j + 1; k < list.size(); k++) {
                if (list.get(j).getKey().end <= list.get(k).getKey().start) {
                    res[list.get(j).getValue()] = list.get(k).getValue();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res[list.get(j).getValue()] = -1;
            }
        }

        res[list.get(intervals.length - 1).getValue()] = -1;
        return res;
    }

    public int[] findRightInterval2(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);//返回与该键至少大于或等于给定键，如果不存在这样的键的键 - 值映射，则返回null相关联。
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}
