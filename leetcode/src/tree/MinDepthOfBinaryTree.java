package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Usher
 * @Description:
 * 树的根节点到叶子节点的最小路径长度
 *
 * 非递归的，层序遍历，找到第一个左右结点都为null的情况，就返回
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root){
        if (root == null)
            return 0;
        if (root.left == null && root.right == null){
            return 1;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            depth++;
            for (int i = 0;i < len;i++){
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return 0;
    }
}
