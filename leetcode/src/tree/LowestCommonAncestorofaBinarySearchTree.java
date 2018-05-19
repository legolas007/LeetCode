package tree;

/**
 * @Author: Usher
 * @Description:
 * 二叉排序树
 * 两个节点 p, q 的公共祖先 root 满足 p.val <= root.val && root.val <= q.val，只要找到满足这个条件的最低层节点即可
 * 后序遍历，先在左右子树中查找解，最后再考虑根节点的解
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);

        return root;
    }
}
