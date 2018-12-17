package array;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 * [1,4],[2,6],[7,10]
 * [1,6],[7,10]
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));

        LinkedList<Interval> result = new LinkedList<>();
        intervals.forEach(interval -> {
            if (result.isEmpty()|| result.getLast().end < interval.start) {
                result.add(interval);
            }else result.getLast().end = Integer.max(result.getLast().end, interval.end);
        });
        return result;
    }
    public List<Interval> merge2(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        List<Interval> result = new ArrayList<>();
        intervals.forEach(interval -> {
            if (result.size() == 0) {
                result.add(interval);
            }

            Interval pre = result.get(result.size() - 1);
            if (pre.end >= interval.start) {
                pre.end = Integer.max(pre.end, interval.end);
            } else result.add(interval);
        });
        return result;
    }
}
