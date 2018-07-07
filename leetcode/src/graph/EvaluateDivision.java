package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Description:
 *
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> mapMap = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String key1 = equations[i][0];
            String key2 = equations[i][1];

            pair(mapMap, key1, key2, values[i]);
            pair(mapMap,key2,key1,1/values[i]);


        }
        double[] res = new double[queries.length];

        for (int i = 0; i < res.length; i++) {
            String k1 = queries[i][0];
            String k2 = queries[i][1];

            Set<String> visited = new HashSet<>();

            res[i] = findValue(k1,k2, mapMap, visited);
        }

        return res;
    }

    private void pair(Map<String, Map<String, Double>> mapMap, String key1, String key2, double val) {
        if (mapMap.containsKey(key1)) {
            mapMap.get(key1).put(key2, val);
        } else {
            Map<String, Double> map = new HashMap<>();
            map.put(key2, val);
            mapMap.put(key1, map);
        }
    }

    private double findValue(String k1, String k2, Map<String, Map<String, Double>> map, Set<String> visited) {
        Map<String, Double> subMap = map.get(k1);
        if(subMap == null) return -1;
        if(visited.contains(k2) || visited.contains(k1)) return -1;
        if(k1.equals(k2)) return 1;
        if(map.get(k1) == null && map.get(k2) == null) return -1;

        if(subMap.get(k2) != null) return subMap.get(k2);
        Set<String> kSet = subMap.keySet();

        visited.add(k1);
        for(String nextK: kSet) {
            if(visited.contains(nextK)) continue;

            double lastRes = findValue(nextK, k2, map, visited);
            if(lastRes != -1)
                return subMap.get(nextK) * lastRes;

        }
        visited.remove(k1);
        return -1;
    }
}
