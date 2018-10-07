package string;

/**
 * @Author: Usher
 * @Description:
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {
                if (helper(words[i], words[j])) {
                    max = Math.max(max, (words[i].length() * words[j].length()));
                }
            }
        }
        return max;
    }

    private boolean helper(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
