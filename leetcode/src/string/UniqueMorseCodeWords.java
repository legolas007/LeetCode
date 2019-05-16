package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/5/16/0016
 * @Description:
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                stringBuilder.append(morse[s.charAt(i) - 'a']);
            }

            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}
