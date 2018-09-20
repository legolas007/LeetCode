package string;

import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int op1,op2;

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                op2 = stack.pop();
                op1= stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        op1 += op2;
                        break;
                    case '-':
                        op1 -= op2;
                        break;
                    case '*':
                        op1 *= op2;
                        break;
                    case '/':
                        op1 /= op2;
                        break;
                }

                stack.push(op1);
            } else stack.push(Integer.valueOf(token));
        }
        return stack.peek();
    }
}
