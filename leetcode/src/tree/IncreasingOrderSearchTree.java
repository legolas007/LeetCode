package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/12/0012
 * @Description:
 */
public class IncreasingOrderSearchTree {

    List<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;

        //two pointers
        TreeNode ans = new TreeNode(0), newNode = ans;
        inOrder(root);
        for (int v: list) {
            newNode.right = new TreeNode(v);
            newNode = newNode.right;
        }
        return ans.right;

    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            inOrder(root.left);
        }

        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }

    }

}
