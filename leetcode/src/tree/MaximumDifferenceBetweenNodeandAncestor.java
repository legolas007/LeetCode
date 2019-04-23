package tree;

/**
 * @Author: Usher
 * @Date: 2019/4/20/0020
 * @Description:
 */
public class MaximumDifferenceBetweenNodeandAncestor {

    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        inOrder(root,root.val,root.val);
        return res;
    }

    public void inOrder(TreeNode root,int max ,int min) {
        if (root == null)
            return;

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        res = Math.max(res, max - min);

        inOrder(root.left, max, min);
        inOrder(root.right, max, min);
    }
}
