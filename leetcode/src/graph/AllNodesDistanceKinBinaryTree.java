package graph;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 * BFS层次遍历K层
 */
public class AllNodesDistanceKinBinaryTree {

    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(null, root);
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        visited.add(target);
        queue.add(target);
        int k = 0;
        while (!queue.isEmpty() && k <= K) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (k == K) {
                    res.add(node.val);
                }
                for (TreeNode child : graph.get(node)) {
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.add(child);
                    visited.add(child);
                }
            }
            k++;
        }
        return res;
    }

    /**
     * Binary tree 2 graph
     * @param parent
     * @param child
     */
    public void buildGraph(TreeNode parent, TreeNode child) {
        if (child == null) {
            return;
        }
        if (!graph.containsKey(child)) {
            graph.put(child, new ArrayList<TreeNode>());
            if (parent != null ) {
                graph.get(child).add(parent);
                graph.get(parent).add(child);
            }
            buildGraph(child, child.left);
            buildGraph(child, child.right);
        }
    }
}
