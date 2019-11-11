package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/10/6,0006
 * @Description:
 */
public class RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates(String s, int k) {
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int cnt = 0;
            while (i < s.length() && ch == s.charAt(i) && cnt < k) {
                i++;
                cnt++;
            }

            if (cnt == k)
                return removeDuplicates(s.substring(0, i - k) + s.substring(i), k);
        }
        return s;
    }

    public String removeDuplicates2(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) -'a';

            if (!stack.isEmpty() && stack.peek()[0] == ch && stack.peek()[1] == k - 1) {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek()[0] == ch && stack.peek()[1] < k - 1) {
                int[] pair = stack.pop();
                pair[1]++;
                stack.push(pair);
            } else stack.push(new int[]{ch, 1});
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            for (int i = 0; i < pair[1]; i++) {
                stringBuilder.append((char) (pair[0] + 'a'));
            }
        }
        return stringBuilder.reverse().toString();
    }
    }
