package string;

import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/9/8,0008
 * @Description:
 */
public class CountSubstringswithOnlyOneDistinctLetter {
    public static int countLetters(String S) {
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            for (int j = i; j < S.length(); j++) {
                if (S.charAt(j) == ch) {
                    cnt++;
                }else break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countLetters("aaaba"));
    }
}
