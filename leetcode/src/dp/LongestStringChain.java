package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/5/24/0024
 * @Description:
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                continue;
            }

            map.put(words[i], 1);
            for (int j = 0; j < words[i].length(); j++) {
                StringBuilder stringBuilder = new StringBuilder(words[i]);

                stringBuilder.deleteCharAt(j);
                String nextStr = stringBuilder.toString();

                if (map.containsKey(nextStr) && map.get(nextStr) + 1 > map.get(words[i])) {
                    map.put(words[i], map.get(nextStr) + 1);
                }
            }

            res = Math.max(res, map.get(words[i]));

        }
        return res;
    }
}
