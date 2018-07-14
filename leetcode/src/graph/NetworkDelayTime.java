package graph;


import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 *
 * [[2, 1, 1], [2, 3, 1], [3, 4, 1]]
 * 4
 * 2
 *
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {

        final int MAX_TIME = 6000 * 100;

        int[][] map = new int[N][N];
        for (int[] m : map) {
            Arrays.fill(m,MAX_TIME);
        }

        for (int[] time : times) {
            map[time[0]-1][time[1]-1] = time[2];
        }
        for (int i = 0; i < N; i++) {
            map[i][i] = 0;
        }
        floyd(map,N);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (map[K-1][i] >= MAX_TIME)
                return -1;
            ans = Math.max(ans, map[K - 1][i]);
        }
        return ans;
    }

    private void floyd(int[][] map,int n) {
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);

    }
}
