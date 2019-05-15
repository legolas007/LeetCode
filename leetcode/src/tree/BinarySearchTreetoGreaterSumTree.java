package tree;

/**
 * @Author: Usher
 * @Date: 2019/5/13/0013
 * @Description:
 */
public class BinarySearchTreetoGreaterSumTree {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }
}
