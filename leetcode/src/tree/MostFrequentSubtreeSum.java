package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class MostFrequentSubtreeSum {
    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        post(root, map);
        List<Integer> ls = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                ls.add(key);
            }
        }
        int[] nums = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            nums[i] = ls.get(i);
        }
        return nums;
    }


    private int post(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return 0;
        int leftSum = post(node.left, map);
        int rightSum = post(node.right, map);
        int sum = leftSum + rightSum + node.val;
        map.merge(sum, 1, Integer::sum);

        max = Math.max(max, map.get(sum));
        return sum;
    }
}
