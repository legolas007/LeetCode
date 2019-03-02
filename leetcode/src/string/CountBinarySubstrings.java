package string;

/**
 * @Author: Usher
 * @Date: 2019/3/2/0002
 * @Description:
 * 00110011
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int res = 0, pre = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }

            if (pre >= cur)
                res++;
        }
        return res;
    }
}
