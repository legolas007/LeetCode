package string;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/6/4/0004
 * @Description:
 */
public class UniqueLetterString {
    public int uniqueLetterString(String S) {
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = i+1; j < S.length(); j++) {
                String subString = S.substring(i, j);
                res += uniq(subString);
                res %= 1000000000 + 7;
            }
        }
        return res;
    }

    int uniq(String s) {
        int[] c =new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (c[i] == 1) {
                cnt++;
            }
        }
        return cnt;
    }

    public int uniqueLetterString2(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int[][] cnt = new int[26][2];
        for (int i = 0; i < 26; i ++) {
            Arrays.fill(cnt[i], -1);
        }
        int sum = 0;
        for (int i = 0; i < S.length(); i ++) {
            cnt[S.charAt(i) - 'A'][0] = cnt[S.charAt(i) - 'A'][1];
            cnt[S.charAt(i) - 'A'][1] = i;
            int tmp = 0;
            for (int j = 0; j < 26; j ++) {
                tmp += (cnt[j][1] - cnt[j][0]);
            }
            sum += tmp;
        }
        return sum;
    }
}
