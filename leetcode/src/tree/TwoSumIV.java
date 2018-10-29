package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class TwoSumIV {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        if (list.size() <= 1) {
            return false;
        }
        int start = 0;
        int end = list.size()-1;
        int sum = 0;
        while (start < end) {
            sum = list.get(start) + list.get(end);
            if (k == sum) {
                return true;
            } else if (sum < k) {
                start++;
            } else end--;
        }
        return false;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
