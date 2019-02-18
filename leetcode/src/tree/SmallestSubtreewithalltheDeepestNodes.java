package tree;

/**
 * @Author: Usher
 * @Date: 2019/2/13/0013
 * @Description:
 */
public class SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        if (leftDepth == rightDepth) {
            return root;
        } else if (leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }

    }

    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return Math.max(left, right) + 1;

    }
}
