package string;

/**
 * @Author: Usher
 * @Description:
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {

        String[] strings = s.split(" ");
        if (strings.length == 0)
            return 0;
        return strings[strings.length - 1].length();
    }
}
