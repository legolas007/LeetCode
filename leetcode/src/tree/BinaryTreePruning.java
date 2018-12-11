package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return (root.left == null && root.right == null && root.val == 0) ? null : root;
    }
}
