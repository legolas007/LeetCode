package dp;

/**
 * @Author: Usher
 * @Date: 2018/12/18/0018
 * @Description:
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * Ø r a b b b i t
 * Ø 1 1 1 1 1 1 1 1
 * r 0 1 1 1 1 1 1 1
 * a 0 0 1 1 1 1 1 1
 * b 0 0 0 1 2 3 3 3
 * b 0 0 0 0 1 3 3 3
 * i 0 0 0 0 0 0 3 3
 * t 0 0 0 0 0 0 0 3
 * 当 T[i - 1] == S[j - 1] 时，dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]，若不等， dp[i][j] = dp[i][j - 1]
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];


        for (int i = 0; i <= s.length(); ++i) dp[0][i] = 1;
        for (int i = 1; i <= t.length(); ++i) dp[i][0] = 0;
        for (int i = 1; i <= t.length(); ++i) {
            for (int j = 1; j <= s.length(); ++j) {
                dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[t.length()][s.length()];
    }
}
