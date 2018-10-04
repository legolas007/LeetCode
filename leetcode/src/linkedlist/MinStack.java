package linkedlist;

import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MinStack() {

    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty()) {
            s2.push(x);
        } else if (x <= s2.peek()) {
            s2.push(x);
        }
    }

    public void pop() {
        int data = s1.pop();
        if (data == s2.peek()) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
