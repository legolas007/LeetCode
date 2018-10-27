package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class FindModeInNinarySearchTree {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root);
        for (Map.Entry entry : map.entrySet()) {

            if ((int)entry.getValue() == count) {
                list.add((Integer)entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        map.merge(root.val, 1, Integer::sum);
        count = Math.max(count, map.get(root.val));
        inOrder(root.right);
    }
}
