package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/1/11/0011
 * @Description:
 */
public class LeafSimilarTrees {

    List<Integer> rootList1;
    List<Integer> rootList2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;
        rootList1 = new ArrayList<>();
        rootList2 = new ArrayList<>();
        helper(root1, rootList1);
        helper(root2, rootList2);

        if (rootList1.size() != rootList2.size())
            return false;

        for (int i = 0; i < rootList2.size(); i++) {
            if (!rootList2.get(i).equals(rootList1.get(i))) {
                return false;
            }
        }
        return true;
    }

    //dfs
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (root.right == null && root.left == null)
            res.add(root.val);
        if (root.left != null)
            helper(root.left,  res);
        if (root.right != null)
            helper(root.right, res);

    }
}
