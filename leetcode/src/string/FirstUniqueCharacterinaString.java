package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char c = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                c = (char) entry.getKey();
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
