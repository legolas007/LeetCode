package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/28/0028
 * @Description:
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {

        List<String> res = new ArrayList<>();

        for (String word : d) {
            int f = 0;

            //字符串是否包含word
            for (Character character : s.toCharArray()) {
                if (f < word.length() && character == word.charAt(f)) {
                    f++;
                }
            }

            if (f == word.length()) {
                res.add(word);
            }
        }

        if (res.size() == 0) {
            return "";
        }
        res.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        });

        return res.get(0);

    }
}
