package tree;

/**
 * @Author: Usher
 * @Date: 2019/3/2/0002
 * @Description:
 */
public class SearchinaBinarySearchTree {
    TreeNode resNode;
    public TreeNode searchBST(TreeNode root, int val) {
        inOrder(root, val);
        return resNode;
    }

    void inOrder(TreeNode root,int val) {
        if (root == null)
            return;
        inOrder(root.left,val);
        if (root.val == val) {
            resNode = root;
        }
        inOrder(root.right, val);
    }
}
