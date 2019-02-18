package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/2/13/0013
 * @Description:
 */
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (Character character : J.toCharArray()) {
            set.add(character);
        }

        int sum = 0;
        for (Character character : S.toCharArray()) {
            if (set.contains(character)) {
                sum++;
            }
        }
        return sum;
    }
}
