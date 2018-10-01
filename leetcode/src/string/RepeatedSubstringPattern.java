package string;

/**
 * @Author: Usher
 * @Description:
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length()/2; i++) {
            if (s.length() % i == 0) {
                int count = s.length() / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    sb.append(s, 0, i);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
