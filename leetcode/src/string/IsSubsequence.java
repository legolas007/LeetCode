package string;

/**
 * @Author: Usher
 * @Description:
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            j = t.indexOf(c, j);
            if (j == -1) {
                return false;
            }
            j++;
        }
        return true;
    }
}
