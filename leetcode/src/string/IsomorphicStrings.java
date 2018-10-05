package string;

/**
 * @Author: Usher
 * @Description:
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] ints = new int[256];
        int[] intt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (ints[s.charAt(i)] != intt[t.charAt(i)])
                return false;
            ints[s.charAt(i)] = i+1;
            intt[t.charAt(i)] = i+1;
        }
        return true;
    }
}
