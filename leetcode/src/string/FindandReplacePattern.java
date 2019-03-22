package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/3/16/0016
 * @Description:
 */
public class FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        Set<Character> patternSet = new HashSet<>();
        for (Character character : pattern.toCharArray()) {
            patternSet.add(character);
        }

        for (String word : words) {
            Set<Character> wordSet = new HashSet<>();

            for (Character character : word.toCharArray()) {
                wordSet.add(character);
            }

            boolean flag = true;

            if (patternSet.size() == wordSet.size() && pattern.length() == word.length()) {
                Map<Character, Character> map = new HashMap<>();
                for (int i = 0; i < pattern.length(); i++) {
                    if (!map.containsKey(pattern.charAt(i))) {
                        map.put(pattern.charAt(i), word.charAt(i));
                    } else {
                        if (map.get(pattern.charAt(i)) != word.charAt(i)) {
                            flag = false;
                        }
                    }
                }
            } else {
                flag = false;
            }

            if (flag) {
                result.add(word);
            }
        }
        return result;
    }
}
