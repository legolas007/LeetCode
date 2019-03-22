package tree;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/3/16/0016
 * @Description:
 */
public class ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++)
            addTreeNode(root, preorder[i]);
        return root;
    }

    private TreeNode addTreeNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val)
            root.right = addTreeNode(root.right, val);
        else root.left = addTreeNode(root.left, val);
        return root;
    }
}
