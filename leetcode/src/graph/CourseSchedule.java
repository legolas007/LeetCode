package graph;

import java.util.ArrayList;

/**
 * @Author: Usher
 * @Description:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited , i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否有环，有false，无true
     * @param graph
     * @param visited
     * @param s
     * @return
     */
    private boolean dfs(ArrayList[] graph, boolean[] visited, int s) {
        if (visited[s]) {
            return false;
        }else {
            visited[s] = true;
        }

        for (int i = 0; i < graph[s].size(); i++) {
            int adj = (int) graph[s].get(i);
            if (!dfs(graph, visited,  adj)) {
                return false;
            }
        }

        visited[s] = false;
        return true;
    }
}
