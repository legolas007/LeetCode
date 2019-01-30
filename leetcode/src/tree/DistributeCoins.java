package tree;

/**
 * @Author: Usher
 * @Date: 2019/1/30/0030
 * @Description:
 */
public class DistributeCoins {
    int res = 0;
    public int distributeCoins(TreeNode root) {

        balance(root);
        return res;
    }

    int balance(TreeNode root) {
        if (root == null)
            return 0;

        int l = balance(root.left);
        int r = balance(root.right);

        res += Math.abs(l) + Math.abs(r);
        return l + r + root.val - 1;
    }
}
