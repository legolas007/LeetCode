package greedy;

import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int len = num.length() - k;

        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            //pop k
            while (!stack.isEmpty() && stack.peek() > cur && stack.size() + k > i) {
                stack.pop();
            }
            stack.push(cur);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        for (char c : stack) {
            if (index == 0 && c == '0') {
                continue;
            }
            index++;

            if (index <= len) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
