package string;

/**
 * @Author: Usher
 * @Description:
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String tmp = s.substring(i, j);
                if (isHuiWen(tmp)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean isHuiWen(String text) {
        StringBuilder sb = new StringBuilder(text);
        return text.equals(sb.reverse().toString());
    }
}
