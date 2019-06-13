package tree;

/**
 * @Author: Usher
 * @Date: 2019/6/8/0008
 * @Description:
 */
public class CountCompleteTreeNodes {
    private int cnt = 0;
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //inOrder(root);
        //return cnt;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        cnt++;
        inOrder(root.right);
    }
}
