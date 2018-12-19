package tree;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2018/12/18/0018
 * @Description:
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null)
            return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();

            for (int i = 0;i < cnt;i++){
                TreeNode node = queue.poll();
                if (reverse) {
                    list.add(0,node.val);
                }else {
                    list.add(node.val);
                }

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            /*if (reverse)
                Collections.reverse(list);*/
            reverse = !reverse;
            ret.add(list);
        }
        return ret;
    }
}
