package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Usher
 * @Description:
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i <n;i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
