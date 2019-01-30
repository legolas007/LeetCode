package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/1/15/0015
 * @Description:
 */
public class UnivaluedBinaryTree {
    private Set<Integer> set = new HashSet<>();
    public boolean isUnivalTree(TreeNode root) {
        inOrder(root);

        return set.size() <= 1;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (set.size()>1)
            return;
        set.add(root.val);
        inOrder(root.right);

    }
}
