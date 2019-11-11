package string;

/**
 * @Author: Usher
 * @Date: 2019/11/2,0002
 * @Description:
 */
public class SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        int l = 0, r = 0, cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }

            if (l == r && l != 0) {
                cnt++;
                l = r = 0;
            }
        }

        return cnt;
    }
}