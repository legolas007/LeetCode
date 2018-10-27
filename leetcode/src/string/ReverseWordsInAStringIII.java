package string;

/**
 * @Author: Usher
 * @Description:
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i =0;i < strings.length;i++) {
            res.append(reverse(strings[i]));
            if (i != strings.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}
