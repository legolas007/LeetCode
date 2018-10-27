package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 * 使用一个哈希表来建立每一个断点的长度和其出现频率之间的映射，
 * 这样只要我们从断点频率出现最多的地方劈墙，损坏的板砖一定最少
 *
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List list : wall) {
            int sum = 0;
            for (int i =0;i < list.size()-1;i++) {
                sum += (Integer) list.get(i);
                map.merge(sum, 1, Integer::sum);
                max = Math.max(max, map.get(sum));
            }
        }
        return wall.size() - max;
    }
}
