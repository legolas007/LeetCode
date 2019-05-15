package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/5/13/0013
 * @Description:
 */
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int k = 1; k <= 4; k++) {
                set.add(k);
            }

            for (int node : map.get(i)) {
                if (set.contains(res[node - 1]))
                    set.remove(res[node - 1]);
            }
            res[i - 1] = set.iterator().next();
        }
        return res;
    }
}
