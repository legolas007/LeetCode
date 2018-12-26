package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/22/0022
 * @Description:
 * binary tree dfs path
 */
public class SumRoottoLeafNumbers {
    List<String> res;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        res = new ArrayList<>();
        String string = "";
        helper(root, string+root.val, res);

        return res.stream().mapToInt(Integer::valueOf).sum();
    }

    public void helper(TreeNode root, String string, List<String> res) {
        if (root == null)
            return;
        if (root.right == null && root.left == null)
            res.add(string);
        if (root.left != null)
            helper(root.left, string+root.left.val, res);
        if (root.right != null)
            helper(root.right, string+root.right.val, res);

    }
}
