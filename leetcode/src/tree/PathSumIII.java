package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSum(TreeNode node, int pre, int sum) {
        if (node == null)
            return 0;
        int cur = pre + node.val;
        return (cur == sum?1:0) + pathSum(node.left, cur, sum) + pathSum(node.right, cur, sum);
    }
}
