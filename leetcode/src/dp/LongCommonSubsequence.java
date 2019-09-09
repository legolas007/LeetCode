package dp;

/**
 * @Author: Usher
 * @Date: 2019/8/24,0024
 * @Description:
 * dp[i][j],i结尾和j结尾的共同
 * dp[i][0] = 0,dp[0][j] = 0
 * dp[i][j] = dp[i-1][j-1] + 1,if text1[i] == text2[j]
 * dp[i][j] = max(dp[i-1][j],dp[i][j-1]), if text1[i] != text2[j]
 */
public class LongCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length() + 1, col = text2.length() + 1;

        int[][] dp = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
