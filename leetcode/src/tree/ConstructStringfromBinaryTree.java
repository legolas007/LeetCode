package tree;

/**
 * @Author: Usher
 * @Date: 2019/1/12/0012
 * @Description:
 */
public class ConstructStringfromBinaryTree {
    StringBuilder res = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        helper(t);
        return res.substring(1, res.length() - 1);
    }

    void helper(TreeNode t) {
        if (t == null)
            return;

        res.append("(").append(t.val);

        if (t.left == null && t.right != null) {
            res.append("()");
        }

        helper(t.left);
        helper(t.right);

        res.append(")");

    }
}
