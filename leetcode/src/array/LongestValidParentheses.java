package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Date: 2019/1/5/0005
 * @Description:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 */
public class LongestValidParentheses {
    //time limited
    public int longestValidParentheses(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    res = Integer.max(res, j - i);
                }
            }
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    res = Integer.max(res, i - deque.peek());
                }
            }
        }
        return res;
    }

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
