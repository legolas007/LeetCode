package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Usher
 * @Description:
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null)
            return null;
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (--d == 0)
                return root;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (d == 1) {
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(v);
                    node.right = new TreeNode(v);
                    node.left.left = left;
                    node.right.right = right;
                } else {
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
