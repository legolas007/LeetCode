package array;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 *
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0, j = 0; i < popped.length; i++) {
            s.push(pushed[i]);
            //比较栈顶是否等于出站序列元素
            while (s.size() > 0 && s.peek() == popped[j]) {
                s.pop();//删除栈顶元素
                j++;//出栈序列后移
            }
        }
        return s.isEmpty();
    }
}

