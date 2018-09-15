package array;

import java.util.HashSet;

/**
 * @Author: Usher
 * @Description:
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int len = s.length();
        int count = 0;

        if (len == 0)
            return 0;

        for (int i = 0; i < len; i++) {
            if (hashSet.contains(s.charAt(i))) {
                hashSet.remove(s.charAt(i));
                count++;
            } else {
                hashSet.add(s.charAt(i));
            }
        }
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
