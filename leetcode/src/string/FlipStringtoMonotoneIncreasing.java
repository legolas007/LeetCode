package string;

/**
 * @Author: Usher
 * @Description:
 */
public class FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int[] to0 = new int[S.length()];
        int[] to1 = new int[S.length()];

        to0[0] = S.charAt(0) - '0';
        to1[0] = 1 - (S.charAt(0) - '0');

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                to0[i] = to0[i - 1];
                to1[i] = 1 + Integer.min(to0[i - 1], to1[i - 1]);
            } else if (S.charAt(i) == '1') {
                to0[i] = 1 + to0[i - 1];
                to1[i] = Integer.min(to0[i - 1], to1[i - 1]);
            }
        }
        return Integer.min(to0[S.length() - 1], to1[S.length() - 1]);
    }
}
