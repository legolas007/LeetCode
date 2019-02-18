package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/2/15/0015
 * @Description:
 */
public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {

        List<Interval> list = new ArrayList<>();

        String s = "";

        int i = 0, j = 0;
            while (i < B.length && j < A.length){
                if (B[i].start <= A[j].start && B[i].end >= A[j].start ||
                        B[i].start >= A[j].start && B[i].start <= A[j].end) {

                    int start = Integer.max(B[i].start, A[j].start);
                    int end = Integer.min(B[i].end, A[j].end);
                    list.add(new Interval(start, end));

                    if (A[j].end < B[i].end) {
                        j++;
                    } else if (A[j].end > B[i].end) {
                        i++;
                    }else {
                        i++;
                        j++;
                    }
                } else {
                    if (A[j].start > B[i].end) {
                        i++;
                    } else j++;
                }
            }



        Interval[] intervals = new Interval[list.size()];
        list.toArray(intervals);
        return intervals;
    }

}
