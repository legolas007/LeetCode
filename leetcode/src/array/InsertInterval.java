package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/5/0005
 * @Description:
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        List<Interval> res;
        res = merge(intervals);
        return res;
    }

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
}
