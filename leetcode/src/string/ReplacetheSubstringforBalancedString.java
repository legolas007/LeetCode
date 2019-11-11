package string;

/**
 * @Author: Usher
 * @Date: 2019/11/2,0002
 * @Description:
 */
public class ReplacetheSubstringforBalancedString {
    public int balancedString(String s) {
        int mean = s.length() / 4;

        int[] ch = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'A']++;
        }

        int k = 0, res = s.length();

        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'A']--;
            while (k < s.length() && ch['Q' - 'A'] <= mean && ch['W' - 'A'] <= mean && ch['E' - 'A'] <= mean && ch['R' - 'A'] <= mean) {
                res = Math.min(res, i - k + 1);
                ch[s.charAt(k++)]++;
            }
        }
        return res;
    }
}
