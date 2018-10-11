package string;

/**
 * @Author: Usher
 * @Description:
 */
public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
            if (hash[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return '0';
    }
}
