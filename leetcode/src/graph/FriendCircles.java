package graph;

/**
 * @Author: Usher
 * @Description:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }

        int n = M.length;
        boolean[] visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            dfs(M, i, n, visited);
            ans++;
        }
        return ans;
    }

    private void dfs(int[][] M, int cur, int n, boolean[] visited) {
        if (visited[cur]) {
            return;
        }

        visited[cur] = true;
        //遍历其所有的朋友
        for (int i = 0; i < n; i++) {
            if (M[cur][i] != 0 && !visited[i]) {
                dfs(M,i,n,visited);
            }
        }
    }
}
