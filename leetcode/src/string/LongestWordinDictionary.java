package string;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class LongestWordinDictionary {

    public static String longestWord(String[] words) {

        String result = "";
        Set<String> stringSet = new HashSet<>(Arrays.asList(words));

        for (String s : words) {
            if (s.length() < result.length() || (s.length() == result.length() && s.compareTo(result) > 0)) {
                continue;
            }
            String prefix="";
            boolean flag = true;
            for (int i = 0; i < s.length()-1 && flag; i++) {
                prefix += s.charAt(i);
                if (!stringSet.contains(prefix))
                    flag = false;
            }

            if (flag)
                result = s;
        }
        return result;
    }

}
