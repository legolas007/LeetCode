package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/2/17/0017
 * @Description:
 */
public class MagicDictionary {

    private Map<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {

        for (String word : dict) {
            if (!map.containsKey(word.length())) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(word.length(), list);
             }else {
                List<String> list = map.get(word.length());
                list.add(word);
                map.put(word.length(), list);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (!map.containsKey(word.length())) {
            return false;
        }
        for (String string : map.get(word.length())) {
            int cnt = 0, i = 0;
            for (; i < word.length(); i++) {
                if (word.charAt(i) == string.charAt(i))
                    continue;

                if (word.charAt(i) != string.charAt(i) && cnt == 1)
                    break;

                cnt++;
            }

            if (i == word.length() && cnt == 1)
                return true;
        }
        return false;
    }
}
