package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Description: 二叉搜索树的非递归实现
 */
public class BSTIterator {
    private Deque<TreeNode> deque;

    public BSTIterator(TreeNode root) {
        deque = new ArrayDeque<>();
        while (root != null) {
            deque.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = deque.poll();
        int res = node.val;
        node = node.right;
        while (node != null) {
            deque.push(node);
            node = node.left;
        }
        return res;
    }
}
