package dp;

/**
 * @Author: Usher
 * @Description:
 * Input:
 *
 * "bbbab"
 * Output:
 * 4
 *
 * case1：s[i] == s[j]
 * a****a -> dp[i][j]=dp[i+1][j-1]+2
 *
 * case2:s[i]!=s[j]
 * ab***b dp[i][j] = dp[i+1][j]
 * a***ab dp[i][j] = dp[i][j-1]
 * i    j
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i=s.length()-1;i >= 0;i--){
            dp[i][i] = 1;
            for (int j=i+1;j < s.length();j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
