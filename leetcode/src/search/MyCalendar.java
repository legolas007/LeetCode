package search;

import java.util.TreeMap;

/**
 * @Author: Usher
 * @Description:
 */
public class MyCalendar {
    TreeMap<Integer, Integer> cal;
    public MyCalendar() {
        cal = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = cal.floorKey(start);//返回小于等于它的最大值
        if (floorKey != null && cal.get(floorKey) > start)
            return false;
        Integer ceilingKey = cal.ceilingKey(start);//返回大于等于它的最小值
        if (ceilingKey != null && ceilingKey < end)
            return false;
        cal.put(start, end);
        return true;
    }
}
