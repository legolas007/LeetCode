package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        //先前序遍历，如果遍历到的节点有子节点，就交换它的两个子节点，
        //当交换完所有非叶子节点后，就得到了树的镜像
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
