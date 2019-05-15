package tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Usher
 * @Date: 2019/5/14/0014
 * @Description:
 */
public class SecondMinimumNodeInaBinaryTree {
    Set<Integer> set = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        inOrder(root);
        set.remove(set.iterator().next());
        return set.iterator().next();
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        set.add(root.val);
        inOrder(root.right);
    }

}
