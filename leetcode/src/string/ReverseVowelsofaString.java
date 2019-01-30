package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/1/18/0018
 * @Description:
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {

        LinkedList<Character> list = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i = 0; i < s.length(); i++) {

            if (set.contains(s.charAt(i))) {
                list.addFirst(s.charAt(i));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                stringBuilder.append(list.get(j++));

            } else stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
