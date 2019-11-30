package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/11/23,0023
 * @Description:
 */
public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addFirst(new int[]{0, i});
            } else if (s.charAt(i) == ')') {
                if (!deque.isEmpty()) {
                    int[] peek = deque.peekFirst();
                    if (peek[0] == 0) {
                        deque.pollFirst();
                    } else {
                        deque.addFirst(new int[]{1, i});
                    }
                } else {
                    deque.addFirst(new int[]{1, i});
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        while (!deque.isEmpty()) {
            set.add(Objects.requireNonNull(deque.pollFirst())[1]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
