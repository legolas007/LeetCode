package string;

import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/6/8/0008
 * @Description:
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int res = 0, num = 0, n = s.length();

        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= '0') {
                num = num * 10 + s.charAt(i) - '0';
            }

            //+-*/
            if ((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i == n - 1) {
                if (op == '+') {
                    stack.push(num);
                }

                if (op == '-') {
                    stack.push(-num);
                }

                if (op == '*' || op == '/') {
                    int tmp = (op == '*') ? stack.peek() * num : stack.peek() / num;
                    stack.pop();
                    stack.push(tmp);
                }

                op = s.charAt(i);
                num = 0;

            }
        }

        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
