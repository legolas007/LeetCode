package dp;

/**
 * @Author: Usher
 * @Description:
 * 定义一个二维数组 dp 用来存储最长公共子序列的长度，其中 dp[i][j] 表示 S1 的前 i 个字符与 S2 的前 j 个字符最长公共子序列的长度。考虑 S1i 与 S2j 值是否相等，分为两种情况：
 *
 * ① 当 S1i==S2j 时，那么就能在 S1 的前 i-1 个字符与 S2 的前 j-1 个字符最长公共子序列的基础上再加上 S1i 这个值，最长公共子序列长度加 1 ，即 dp[i][j] = dp[i-1][j-1] + 1。
 *
 * ② 当 S1i != S2j 时，此时最长公共子序列为 S1 的前 i-1 个字符和 S2 的前 j 个字符最长公共子序列，与 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列，它们的最大者，即 dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }。
 *
 */
public class DeleteOperationforTwoStrings {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lengthOfLCS(word1, word2);
    }

    int lengthOfLCS(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
