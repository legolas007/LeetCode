package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2018/12/18/0018
 * @Description:
 */
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        ArrayList vals1 = new ArrayList();
        ArrayList vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    public void dfs(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;

            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }

            vals.add(null);
        }
    }
    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        if (root1==root2)
            return true;
        if (root1==null || root2== null||root1.val != root2.val)
            return false;
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
                || flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
}
