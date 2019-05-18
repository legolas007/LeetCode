package tree;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/5/16/0016
 * @Description:
 */
public class SmallestStringStartingFromLeaf {
    List<String> list;
    public String smallestFromLeaf(TreeNode root) {
        list = new ArrayList<>();
        String s = "" + (char) (root.val + 'a');
        helper(root, s);

        Collections.sort(list);
        return list.get(0);
    }

    void helper(TreeNode root, String s) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(s);
        }

        if (root.left != null) {
            helper(root.left,  (char) (root.left.val + 'a') + s);
        }
        if (root.right != null) {
            helper(root.right, (char) (root.right.val + 'a') + s);
        }
    }

}
