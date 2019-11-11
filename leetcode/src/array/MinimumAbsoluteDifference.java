package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/9/28,0028
 * @Description:
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new LinkedList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        if (res.isEmpty()) {
            return res;
        }
        //res.sort(Comparator.comparingInt(o -> o.get(0)));

        return res;
    }
}
