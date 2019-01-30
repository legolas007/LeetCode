package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/1/19/0019
 * @Description:
 */
public class CustomSortString {
    public String customSortString(String S, String T) {

        int[] hash = new int[26];
        for (Character character : T.toCharArray()) {
            hash[character - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : S.toCharArray()) {
            while (hash[character - 'a']-- > 0)
                stringBuilder.append(character);
        }

        for (Character character : T.toCharArray()) {
           while (hash[character - 'a']-- >0)
               stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
