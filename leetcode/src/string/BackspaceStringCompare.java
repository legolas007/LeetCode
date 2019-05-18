package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Date: 2019/5/17/0017
 * @Description:
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }

    String helper(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                deque.offer(s.charAt(i));
            } else {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            }
        }

        return String.valueOf(deque);
    }
}
