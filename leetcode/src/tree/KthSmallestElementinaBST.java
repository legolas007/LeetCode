package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class KthSmallestElementinaBST {
    int result,curCount;
    public int kthSmallest(TreeNode root, int k) {
        curCount = 0;
        result = root.val;
        inOrder(root, k);
        return result;

    }

    public void inOrder(TreeNode root,int k) {
        if (root == null) {
            return ;
        }
        inOrder(root.left, k);
        curCount++;
        if (curCount == k) {
            result = root.val;
        }
        inOrder(root.right, k);
    }
}
