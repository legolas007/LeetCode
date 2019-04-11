package search;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/3/23/0023
 * @Description:
 * 二分图，染色定理bfs实现
 */
public class PossibleBipartition {


    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int[] d : dislikes) {
            adj[d[0]].add(d[1]);
            adj[d[1]].add(d[0]);
        }

        for(int i = 1; i <= N; i++) {
            if(color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int nb : adj[cur]) {
                        if(color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? -1 : 1;
                            q.add(nb);
                        } else {
                            if(color[nb] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition2(int N, int[][] dislikes) {
        int[][] graph = new int[N + 1][N + 1];

        for (int[] dislike : dislikes) {
            graph[dislike[0]][dislike[1]] = 1;
            graph[dislike[1]][dislike[0]] = 1;
        }

        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(graph, i, 1, colors)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int cur, int color, int[] colors) {
        colors[cur] = color;

        for (int i = 0; i < graph.length; i++) {
            if (graph[cur][i] == 1) {
                if (colors[i] == color) {
                    return false;
                }
                if (colors[i] == 0 && !dfs(graph, i, -color, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
