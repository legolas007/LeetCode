package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class DiameterOfBinaryTree {
    private int longestPath;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        maxSinglePath(root);
        return longestPath;
    }

    private int maxSinglePath(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxSinglePath(root.left);
        int right = maxSinglePath(root.right);

        int val = left + right + 1;
        longestPath = Math.max(val, longestPath);
        return Math.max(left, right) + 1;
    }

}
