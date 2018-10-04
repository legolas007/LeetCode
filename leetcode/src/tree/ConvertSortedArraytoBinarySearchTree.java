package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return array2BST(nums, 0, nums.length - 1);
    }

    public TreeNode array2BST(int[] nums, int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) / 2;
        TreeNode cur = new TreeNode(nums[mid]);

        cur.left = array2BST(nums, l, mid - 1);
        cur.right = array2BST(nums, mid+1, r);
        return cur;
    }
}
