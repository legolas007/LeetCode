package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/5/24/0024
 * @Description:
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp= new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int size1 = stack.size();
            while (!stack.isEmpty()) {
                Character character = stack.peek();
                stack.pop();
                if (stack.isEmpty() || character != stack.peek()) {
                    tmp.push(character);
                } else {
                    stack.pop();
                }
            }

            if (size1 == tmp.size()) {
                while (!tmp.isEmpty()) {
                    stringBuilder.append(tmp.peek());
                    tmp.pop();
                }
                break;
            }
            int size2 = tmp.size();
            while (!tmp.isEmpty()) {
                Character character = tmp.peek();
                tmp.pop();
                if (tmp.isEmpty() || character != tmp.peek()) {
                    stack.push(character);
                } else {
                    tmp.pop();
                }
            }
            if (size2 == stack.size()) {
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.peek());
                    stack.pop();
                }
                stringBuilder.reverse();
                break;
            }

        }

        return stringBuilder.toString();

    }
}
