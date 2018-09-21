package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class AllPathsFromSourcetoTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), result);
        return result;
    }
   static void dfs(int[][] graph, int cur, List<Integer> path, List<List<Integer>> result) {
        path.add(cur);

        if (cur == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int edge : graph[cur]) {
            dfs(graph,edge,path,result);
            path.remove(path.size() - 1);
        }
    }
}
