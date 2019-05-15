package string;

/**
 * @Author: Usher
 * @Date: 2019/5/14/0014
 * @Description:
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder stringBuilder = new StringBuilder(A);

        int cnt = 0;
        while (stringBuilder.length() < B.length()) {
            stringBuilder.append(A);
            cnt++;
        }

        if (stringBuilder.toString().contains(B)) {
            return cnt;
        }

        stringBuilder.append(A);
        return stringBuilder.toString().contains(B) ? cnt + 1 : -1;
    }
}
