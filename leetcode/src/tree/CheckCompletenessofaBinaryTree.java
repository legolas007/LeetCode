package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/1/17/0017
 * @Description: 判断一棵树是否是完全二叉树的思路
 * 1>如果树为空，则直接返回错
 * 2>如果树不为空：层序遍历二叉树
 * 2.1>如果一个结点左右孩子都不为空，则pop该节点，将其左右孩子入队列；
 * 2.1>如果遇到一个结点，左孩子为空，右孩子不为空，则该树一定不是完全二叉树；
 * 2.2>如果遇到一个结点，左孩子不为空，右孩子为空；或者左右孩子都为空；则该节点之后的队列中的结点都为叶子节点；该树才是完全二叉树，否则就不是完全二叉树；
 */
public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // if it's null, all nodes in queue should be null as well.
            if (node == null) {
                while (!queue.isEmpty()) {
                    TreeNode n = queue.poll();
                    if (n != null) return false;
                }
            } else {
                // here may put a node into the queue, or put null into the queue
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }


}
