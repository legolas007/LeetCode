package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class UniquePaths {
    /*
    //递归超时
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        if (m < 0 || n < 0)
            return 0;
        if (m == 1&& n == 1)
            return 1;
            //记忆化搜索
        if (f[m][n] > 0)
            return f[m][n];
        int up = uniquePaths(m-1,n);
        int left = uniquePaths(m,n-1);
        f[m][n] = up + left;
        return f[m][n];
    }
    */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m+1][n+1];
        if (m < 0 || n < 0)
            return 0;
        f[1][1] = 1;
        for (int i =1;i <= m;i++){
            for (int j = 1;j <= n;j++){
                if (i == 1&& j == 1){
                    //f[1][1] = 1;
                    continue;
                }else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m][n];
    }
}
