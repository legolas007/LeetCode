package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Usher
 * @Description:
 */
public class MaximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int max_depth = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node tmp = queue.poll();
                if (tmp.children != null) {
                    for (Node node : tmp.children) {
                        queue.offer(node);
                    }
                }
            }
            max_depth++;
        }
        return max_depth;
    }
    public int maxDepth2(Node root) {
        if(root == null) return 0;
        int maxDepth = 0;
        for(Node child : root.children)
            maxDepth = Math.max(maxDepth, maxDepth(child));
        return maxDepth + 1;
    }
}
