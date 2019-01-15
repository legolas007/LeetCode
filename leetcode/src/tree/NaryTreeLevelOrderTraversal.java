package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/1/13/0013
 * @Description:
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);

                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res.add(list);
        }
        return res;
    }
}
