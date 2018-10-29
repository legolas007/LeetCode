package string;

import java.util.Comparator;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        dict.sort(Comparator.comparingInt(String::length));
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : strings) {
            boolean flag = false;
            for (String pattern : dict) {
                if (s.startsWith(pattern)) {
                    sb.append(pattern + " ");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append(s + " ");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
