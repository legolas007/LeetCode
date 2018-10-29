package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        int maxNum = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                maxIdx = i;
            }
        }

       /* List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int max = Collections.max(list);
        int idxMax = list.indexOf(max);*/
        TreeNode node = new TreeNode(maxNum);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx + 1, nums.length));

        return node;
    }
}
