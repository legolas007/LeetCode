package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class KnightProbabilityinChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp0 = new double[N][N];
        dp0[r][c] = 1.0;

        int[][] dirs = {{1,2},{-1,-2},{1,-2},{-1,2},{2,1},{-2,-1},{2,-1},{-2,1}};

        for (int k =0;k < K;k++){
            double[][] dp1 = new double[N][N];
            for (int i=0;i < N;i++){
                for (int j=0;j < N;j++){
                    for (int m=0;m < 8;m++){
                        int x = j + dirs[m][0];
                        int y = i + dirs[m][1];
                        if (x < 0 || y < 0 || x >=N||y >= N)continue;
                        dp1[y][x] += dp0[i][j];
                    }
                }
            }
            dp0 = dp1;

        }
        double total = 0;
        for (int i=0;i < N;i++){
            for (int j =0;j < N;j++){
                total += dp0[i][j];
            }
        }
        return total / Math.pow(8, K);
    }

}
