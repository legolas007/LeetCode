package tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Usher
 * @Date: 2019/5/17/0017
 * @Description:
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        LinkedList<Integer> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                res.addFirst(node.val);

                if (node.children != null) {
                    for (Node tmp : node.children) {
                        queue.addFirst(tmp);
                    }
                }
            }
        }
        return res;
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        postorderTraversal(root, lst);
        return lst;
    }

    public void postorderTraversal(Node node, List<Integer> list) {
        if (node == null) return;

        if (node.children != null) {
            for (Node child : node.children) {
                postorderTraversal(child, list);
            }
        }
        list.add(node.val);
    }
}
