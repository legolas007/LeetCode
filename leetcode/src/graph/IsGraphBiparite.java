package graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Usher
 * @Description:
 * 染色法,二分图
 */
public class IsGraphBiparite {

    public boolean isBipartite(int[][] graph) {
        int n =graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }


    boolean isBipartite2(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) {
                continue;
            }
            colors[i] = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int node : graph[cur]) {
                    if (colors[node] == colors[cur]) {
                        return false;
                    }

                    if (colors[node] == 0) {
                        colors[node] = -1 * colors[cur];
                        queue.offer(node);
                    }
                }
            }
        }
        return true;
    }

    int[] pre;
    boolean isBipartite3(int[][] graph) {
         pre = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            pre[i] = i;
        }

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                continue;
            }

            int x = find(i);
            int y = find(graph[i][0]);

            if (x == y) {
                return false;
            }

            for (int j = 1; j < graph[i].length; j++) {
                int parent = find(graph[i][j]);

                if (x == parent) {
                    return false;
                }

                pre[parent] = y;
            }
        }
        return true;
    }

    int find(int num) {
        return pre[num] == num ? num : find(pre[num]);
    }
}
