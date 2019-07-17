package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/07/14,0014
 * @Description:
 */
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        delNodes(root, set, result, true);
        return result;
    }

    private TreeNode delNodes(TreeNode node, Set<Integer> set,
                              List<TreeNode> result, boolean newRoot) {
        if (node == null) {
            return null;
        }
        if (!set.contains(node.val)) {
            if (newRoot) {
                result.add(node);
            }
            node.left = delNodes(node.left, set, result, false);
            node.right = delNodes(node.right, set, result, false);
            return node;
        } else {
            set.remove(node.val);
            delNodes(node.left, set, result, true);
            delNodes(node.right, set, result, true);
            return null;
        }
    }
}
