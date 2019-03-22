package tree;

/**
 * @Author: Usher
 * @Date: 2019/3/9/0009
 * @Description:
 */
public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        while (root.val < L || root.val > R) {
            root = (root.val < L) ? root.right : root.left;
        }

        TreeNode cur = root;
        for (; cur != null; ) {
            for (; cur.left != null && cur.left.val < L;) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }

        cur = root;

        for (; cur != null; ) {
            for (; cur.right != null && cur.right.val > R; ) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}
