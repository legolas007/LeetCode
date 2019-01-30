package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/1/16/0016
 * @Description:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }

        int res = Integer.MAX_VALUE;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                if (point1[0] == point2[0] || point1[1] == point2[1])
                    continue;

                //对角线
                if (map.get(point1[0]).contains(point2[1]) && map.get(point2[0]).contains(point1[1])) {
                    int tmp = Math.abs((point1[0] - point2[0]) * (point1[1] - point2[1]));

                    res = Integer.min(res, tmp);
                }
            }
        }
        return res== Integer.MAX_VALUE ? 0:res;
    }
}
