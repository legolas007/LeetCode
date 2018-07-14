package graph;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * if have circle ,unsafe
 */
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        String[] states = new String[graph.length];
        Arrays.fill(states, "unknown");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, states).equals("safe")) {
                list.add(i);
            }
        }
        //list.sort(Comparator.naturalOrder());
        Collections.sort(list);
        return list;
    }

    private String dfs(int[][] graph, int cur, String[] states) {
        if (states[cur].equals("visiting")) {
            return "unsafe";
        }

        if (!states[cur].equals("unknown")) {
            return states[cur];
        }

        states[cur] = "visiting";
        for (int next : graph[cur]) {
            if (dfs(graph, next, states).equals("unsafe"))
                return states[cur] = "unsafe";
        }
        return states[cur] = "safe";
    }

}
