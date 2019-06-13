package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/6/12/0012
 * @Description:
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strings = text.split(" ");

        List<String> list = new ArrayList<>();
        for (int i = 2; i < strings.length; i++) {
            if (strings[i - 2].equals(first) && strings[i - 1].equals(second)) {
                list.add(strings[i]);
            }
        }

        String[] res = new String[list.size()];
        int i = 0;
        for (String s : list) {
            res[i++] = s;
        }

        return res;
    }
}
