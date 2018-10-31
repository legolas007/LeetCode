package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Description:
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ) {
                deque.offer(s.charAt(i));
            } else {
                if (deque.isEmpty())
                    cnt++;
                else if (s.charAt(i) == ')' && deque.peek() == '(')
                    deque.pop();
            }
        }
        return deque.size() + cnt;
    }
}
