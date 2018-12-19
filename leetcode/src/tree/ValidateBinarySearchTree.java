package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/17/0017
 * @Description:
 */
public class ValidateBinarySearchTree {
    private List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for (int i = 0; i < res.size()-1; i++) {
            if (res.get(i) > res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
}
