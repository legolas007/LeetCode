package array;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/6/10/0010
 * @Description:
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushList(nestedList);
    }

    private void pushList(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushList(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
