package string;

/**
 * @Author: Usher
 * @Description:
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int res = 0, i = 0, n = s.length();
        while (i + k <= n) {
            int[] hash = new int[26];
            int mask = 0, maxIdx = i;
            for (int j = i; j < n; j++) {
                int t = s.charAt(j) - 'a';
                hash[t]++;
                if (hash[t] < k)
                    mask |= (1 << t);
                else mask &= (~(1 << t));
                if (mask == 0) {
                    res = Integer.max(res, j - i + 1);
                    maxIdx = j;
                }
            }
            i = maxIdx + 1;
        }
        return res;
    }
}
