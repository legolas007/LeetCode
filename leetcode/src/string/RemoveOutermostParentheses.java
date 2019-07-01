package string;

import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/07/01,0001
 * @Description:
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int idxStart = 0;
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                idxStart = i;
                stack.push(S.charAt(i));
            } else if (stack.peek() == '(' && S.charAt(i) == ')'){
                stack.pop();
                if (stack.isEmpty()) {
                    stringBuilder.append(S, idxStart+1, i);
                }
            } else stack.push(S.charAt(i));
        }
        return stringBuilder.toString();
    }
}
