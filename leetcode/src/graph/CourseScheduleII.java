package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2018/12/26/0026
 * @Description:
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;

        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int[] prerequisite2 : prerequisites)
            indegree[prerequisite2[0]]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            for (int[] prerequisite1 : prerequisites) {
                if (prerequisite1[1] == prerequisite) {
                    indegree[prerequisite1[0]]--;
                    if (indegree[prerequisite1[0]] == 0) {

                        order[index++] = prerequisite1[0];
                        queue.offer(prerequisite1[0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}
