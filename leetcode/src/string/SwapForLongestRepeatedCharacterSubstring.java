package string;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/8/24,0024
 * @Description:
 */
public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int len = text.length();
        int[] count = new int[26];

        int[] newCount = new int[26];
        for (char c : text.toCharArray())
            newCount[c - 'a']++;

        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[text.charAt(end) - 'a']);
            while (end - start + 1 - maxCount > 1 || end - start + 1 > newCount[text.charAt(start) - 'a']) {
                count[text.charAt(start) - 'a']--;
                start++;
                maxCount = 0;
                for (int i = 0; i < 26; i++) {
                    if (maxCount < count[i]) {
                        maxCount = count[i];
                    }
                }
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
