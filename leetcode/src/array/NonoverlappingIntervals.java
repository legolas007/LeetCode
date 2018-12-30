package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Usher
 * @Date: 2018/12/30/0030
 * @Description:
 * 
 * 如果前一个区间的end大于后一个区间的start，那么一定是重复区间
 * [1,2][1,3][1,4]
 * [ [1,2], [1,3],[2,3], [3,4]  ]
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int cnt = 0;
        if(intervals.length > 0) {
            //按照end排序
            Arrays.sort(intervals, Comparator.comparingInt(a -> a.end));
            Interval prev = intervals[0];
            for(int i = 1; i < intervals.length; ++i) {
                if(intervals[i].start < prev.end) {
                    ++cnt;
                } else {
                    prev = intervals[i];
                }
            }
        }

        return cnt;
    }
}
