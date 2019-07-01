package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/07/01,0001
 * @Description:
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));

        int sum = 0;
       /* List<int[]> list = new ArrayList<>();
        List<int[]> listNum = new ArrayList<>();*/
        PriorityQueue<int[]> pq =  new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] trip : trips) {
            if (sum != 0) {
                /*int n = list.size();
                for (int[] ints : list) {
                    if (ints[2] <= trip[1]) {
                        sum -= ints[0];
                        listNum.add(ints);
                    }
                }
                if (listNum.size() != 0) {
                    list.removeAll(listNum);
                    listNum.clear();
                }*/
                while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                    sum -= pq.poll()[0];
                }

            }
            //list.add(trip);
            pq.add(trip);
            sum += trip[0];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
