package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2018/12/29/0029
 * @Description: s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * dfs stack
 * two stack :one num,one character
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                deque.push(s.charAt(i));
            } else {
                StringBuilder tmp = new StringBuilder();
                while (deque.peek() != '[') {
                    tmp.append(deque.pop());
                }
                if (deque.peek() == '[') {
                    deque.pop();
                }
                StringBuilder strNum = new StringBuilder();
                while (!deque.isEmpty() && Character.isDigit(deque.peek())) {
                    strNum.append(deque.pop());
                }
                //int count = deque.pop() - '0';
                int count = Integer.valueOf(strNum.reverse().toString());
                int len = tmp.toString().length();
                for (int j = 0; j < count; j++) {
                    for (int k = len - 1; k >= 0; k--) {
                        deque.push(tmp.charAt(k));
                    }
                }
            }
        }
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollLast());
        }
        return stringBuilder.toString();
    }

}
