package graph;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 *
 * DFS,如果没有遍历过，说明是隔离节点，不连通
 */
public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();

        dfs(rooms,0,visited);
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int cur, HashSet<Integer> visited) {
        if (visited.contains(cur))
            return;
        visited.add(cur);

        for (int next : rooms.get(cur)) {
            dfs(rooms, next, visited);
        }
    }
}
