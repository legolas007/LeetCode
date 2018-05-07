package dp;

/**
 * @Author: Usher
 * @Description:
 * dp[i][j]表示S的前i个位置和T的前j个位置对齐的最少得分
 * dp[i][j] = min(dp[i-1][j-1] + same(i,j),dp[i-1][j]+1,dp[i][j-1]+1)
 * dp[i-1][j-1]+same(i,j)对应S第i个字符和T第j个字符对齐
 * dp[i-1][j]+1对应S第i个字符和-对齐，即删掉S中第i个字符
 * dp[i][j-1]+1对应T第j个字符和-对齐，即在S中加入该字符
 * 初值dp[0][j] = j(S为空，添加j位）,dp[i][0]=i（T为空，删除i位）
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int m = word1.length(),n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i =0;i <= m;i++){
            for (int j=0;j <= n;j++){
                if (i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 1),
                            Math.min(dp[i][j-1]+1,dp[i-1][j] +1));
                }
            }
        }
        return dp[m][n];
    }
}
