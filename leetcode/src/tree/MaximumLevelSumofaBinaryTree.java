package tree;


import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/8/18,0018
 * @Description:
 */
public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.add(root);

        int maxSum = 0,depth = 0,curDepth = 0;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();

            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();

                sum += node.val;
                if (node.left != null) {
                    linkedList.add(node.left);
                }

                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }

            depth++;
            if (maxSum < sum) {
                maxSum = sum;
                curDepth = depth;
            }


        }
        return curDepth;
    }
}
