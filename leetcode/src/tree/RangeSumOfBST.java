package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrder(root,L,R);
        return sum;
    }

    private void inOrder(TreeNode root, int L, int R) {
        if (root == null)
            return;
        inOrder(root.left,L,R);
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        inOrder(root.right,L,R);
    }
}
