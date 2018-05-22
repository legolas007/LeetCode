package dp;

import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 * 匹配左括号
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();

        int min_op = 0,max_op = 0;
        for (char c : chars){
            if (c == '(')
                ++min_op;
            else --min_op;

            if (c != ')')
                ++max_op;
            else --max_op;

            if (max_op < 0)
                return false;
            min_op = Math.max(0, min_op);
        }
        return min_op == 0;
    }

    public boolean checkValidString2(String s) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i = 0 ;i<arr.length;++i){
            if(arr[i]=='(')
                leftStack.push(i);
            else if(arr[i] == '*')
                starStack.push(i);
            else{
                if(!leftStack.isEmpty())
                    leftStack.pop();
                else if(!starStack.isEmpty())
                    starStack.pop();
                else
                    return false;
            }
        }

        while(!leftStack.isEmpty()){
            if(!starStack.isEmpty() && starStack.peek()>leftStack.peek()) {
                starStack.pop();
                leftStack.pop();
            }
            else
                return false;
        }

        return true;
    }
}
