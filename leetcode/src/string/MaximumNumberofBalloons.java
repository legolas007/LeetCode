package string;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/9/21,0021
 * @Description:
 */
public class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for (int i = 0; i < text.length(); i++) {
            chars[text.charAt(i) - 'a']++;
        }
        chars['l' - 'a'] /= 2;
        chars['o' - 'a'] /= 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (i == 0) {
                min = Math.min(min, chars[i]);
            }

            if (i == 11) {
                min = Math.min(min, chars[i]);
            }
            if (i == 13) {
                min = Math.min(min, chars[i]);
            }
            if (i == 14) {
                min = Math.min(min, chars[i]);
            }
            if (i == 1) {
                min = Math.min(min, chars[i]);
            }

        }
        return min;
    }
}
