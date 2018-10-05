package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] strings = str.split(" ");

        if (pattern.length() != strings.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!strings[i].equals(map.get(c))) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(c, strings[i]);
            }
        }
        return true;
    }
}
