package string;

import java.nio.channels.Channel;
import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {

        LinkedList<Character> list = new LinkedList<>();
        for (int i =0;i < S.length();i++) {
            if (Character.isLetter(S.charAt(i))) {
                list.add(S.charAt(i));
            }
        }

        Collections.reverse(list);
        //Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                stringBuilder.append(list.remove());
               //stringBuilder.append(list.removeLast());
            } else {
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
