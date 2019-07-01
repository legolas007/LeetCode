package string;

import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/6/12/0012
 * @Description:
 */
public class SmallestSubsequenceofDistinctCharacters {
    public String smallestSubsequence(String text) {
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            last[text.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';

            if (seen[c])
                continue;

            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()]) {
                seen[stack.pop()] = false;
            }

            stack.push(c);
            seen[c] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : stack) {
            stringBuilder.append((char) ('a' + num));
        }
        return stringBuilder.toString();
    }
}
