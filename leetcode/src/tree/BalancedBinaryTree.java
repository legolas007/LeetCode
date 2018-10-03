package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class BalancedBinaryTree {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        TreeDepth(root);
        return flag;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;

    }
}
