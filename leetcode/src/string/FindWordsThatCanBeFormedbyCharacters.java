package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/8/18,0018
 * @Description:
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.merge(chars.charAt(i), 1, Integer::sum);
        }

        int sum = 0;
        for (String word : words) {
            boolean flag = true;

            int cur = word.length();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (map.containsKey(ch) && map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                } else {
                    flag = false;
                    cur = j;
                    break;
                }
            }
            if (flag) {
                sum += word.length();
            }


            for (int j = 0; j < cur; j++) {
                char ch = word.charAt(j);

                if (map.containsKey(ch)) {
                    map.merge(ch, 1, Integer::sum);
                }
            }
        }

        return sum;
    }
}
