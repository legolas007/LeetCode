package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                deque.push(s.charAt(i));
            } else {
                if (deque.isEmpty())
                    return false;
                if (s.charAt(i) == ')' && deque.peek() != '(')
                    return false;
                if (s.charAt(i) == ']' && deque.peek() != '[')
                    return false;
                if (s.charAt(i) == '}' && deque.peek() != '{')
                    return false;
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
