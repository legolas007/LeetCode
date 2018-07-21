package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class MinimumAbsoluteDifferenceinBST {

    int res = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode node) {

        if (node != null) {

            inOrder(node.left);
            if (pre != null) {
                res = Math.min(res, Math.abs(pre.val - node.val));
            }
            pre = node;
            inOrder(node.right);
        }
    }

/*    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }
        return res;
    }

    public void inOrder(TreeNode node) {

        if (node != null) {
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }*/

}
