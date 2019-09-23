package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Usher
 * @Date: 2019/9/21,0021
 * @Description:
 */
public class ReverseSubstringsBetweenEachPairofParentheses {
    public String reverseParentheses(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ')') {
                deque.addLast(s.charAt(i));
            } else {
                StringBuilder stringBuilder = new StringBuilder();

                while (!deque.isEmpty()) {
                    if (deque.peekLast() != '(') {
                        stringBuilder.append(deque.pollLast());
                    } else {
                        deque.pollLast();
                        for (int j = 0; j < stringBuilder.length(); j++) {
                            deque.addLast(stringBuilder.charAt(j));
                        }
                        break;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }

        return stringBuilder.toString();
    }
}
