package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Description:
 */
public class ConvertBSTtoGreaterTree {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.right);
        root.val += sum;
        sum = root.val;
        inOrder(root.left);
    }


}
