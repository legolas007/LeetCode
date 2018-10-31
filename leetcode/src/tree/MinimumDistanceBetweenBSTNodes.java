package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class MinimumDistanceBetweenBSTNodes {
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return -1;
        inOrder(root);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            res = Integer.min(Math.abs(list.get(i) - list.get(i + 1)), res);
        }
        return res;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
