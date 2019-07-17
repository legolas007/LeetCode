package string;

import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/07/07,0007
 * @Description:
 */
public class DecodedStringatIndex {
    public String decodeAtIndex(String S, int K) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                stringBuilder.append(S.charAt(i));
                if (stringBuilder.length() == K) {
                    return String.valueOf(stringBuilder.toString().charAt(K-1));
                }
            } else {

                String tmp = stringBuilder.toString();

                for (int j = 0; j < S.charAt(i)- '0'-1; j++) {
                    stringBuilder.append(tmp);
                    if (stringBuilder.length() == K) {
                        return String.valueOf(stringBuilder.toString().charAt(K-1));
                    }
                }
            }
        }
        return String.valueOf(stringBuilder.toString().charAt(K-1));
    }
    public String decodeAtIndex2(String S, int K) {
            int n = S.length();
            long[] lens = new long[n];
            lens[0] = 1;
            int i = 1;
            while (i < n) {
                if (Character.isDigit(S.charAt(i))) {
                    lens[i] = lens[i - 1] * (S.charAt(i) - '0');
                } else {
                    lens[i] = lens[i - 1] + 1;
                }
                if (lens[i] >= K) {
                    break;
                }
                i++;
            }
            while (Character.isDigit(S.charAt(i)) || lens[i] != K) {
                i--;
                K %= lens[i];
                if (K == 0) {
                    K = (int)lens[i];
                }
            }
            return S.charAt(i) + "";
        }
}
