package tree;

/**
 * @Author: Usher
 * @Description:
 * 两个递归函数，使得写法更加简洁了，首先还是先判断root是否为空，是的话返回0。然后对左右子节点分别调用当前函数，取其中较大值保存到变量sub中，表示左右子树中最长的相同值路径，然后就是要跟当前树的最长相同值路径比较，计算方法是对左右子结点调用一个helper函数，并把当前结点值传进去，把返回值加起来和sub比较，去较大值返回。在helper函数里，当当前结点为空，或者当前节点值不等于父结点值的话，返回0。否则结返回对左右子结点分别调用helper递归函数中的较大值加1，我们发现这种写法跟求树的最大深度很像
 */
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        int sub = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(sub, helper(root.left, root.val) + helper(root.right, root.val));
    }

    public int helper(TreeNode node, int parent) {
        if (node == null || node.val != parent)
            return 0;
        return 1 + Math.max(helper(node.left, node.val), helper(node.right, node.val));
    }
}
