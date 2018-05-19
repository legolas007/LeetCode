package tree;

/**
 * @Author: Usher
 * @Description:
 * 普通二叉树
 *
 * 在左右子树中查找两个节点的最低公共祖先，如果在其中一颗子树中查找到，那么就返回这个解，否则可以认为根节点就是最低公共祖先
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p|| root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left == null)
            return right;
        else if (right == null)
            return left;

        return root;
    }
}
