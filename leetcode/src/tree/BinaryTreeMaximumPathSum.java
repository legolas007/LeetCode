package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class BinaryTreeMaximumPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        maxSum = root.val;
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        int val = root.val;
        if (left > 0)
            val += left;
        if (right > 0)
            val += right;
        maxSum = Math.max(maxSum, val);
        return Math.max(root.val , Math.max(left, right)+root.val) ;
    }
}
