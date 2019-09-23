package tree;

/**
 * @Author: Usher
 * @Date: 2019/9/14,0014
 * @Description:
 * 当一号玩家完成了选择，把其余二叉树节点分成3部分：左孩子节点及其子孙节点，右孩子节点及其子孙节点，
 * 父节点及其他。如果有一个区域的节点数大于另外两个区域的节点数，那么二号玩家能赢。
 *
 */
public class BinaryTreeColoringGame {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null) {
            return false;
        }

        if (root.val == x) {
            int left = count(root.left);
            int right = count(root.right);

            int parent = n - (left + right + 1);
            return parent > (left + right) || left > (parent + right) || right > (left + parent);
        }
        return btreeGameWinningMove(root.left, n, x) || btreeGameWinningMove(root.right, n, x);
    }

    int count(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return count(node.left) + count(node.right) + 1;
    }
}
