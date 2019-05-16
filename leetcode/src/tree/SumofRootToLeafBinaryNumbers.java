package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/5/15/0015
 * @Description:
 */
public class SumofRootToLeafBinaryNumbers {

    List<String> res;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        res = new ArrayList<>();
        String string = "";
        helper(root, string+root.val, res);

        return res.stream().mapToInt(s -> Integer.valueOf(s, 2)).sum();
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

    public int sumRootToLeaf2(TreeNode root) {
        return sum(root, "");
    }

    public int sum(TreeNode node, String pre) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return Integer.parseInt(pre + node.val, 2);
        else
            return sum(node.left, pre + node.val) + sum(node.right, pre + node.val);
    }
}
