package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/17/0017
 * @Description:
 * dfs
 */
public class RecoverBinarySearchTree {
    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        //因为 bst + inOrder 最小的一定是在最前面
        if(prev != null && prev.val >= root.val){
            if(first == null)
                first = prev;
            // 第二次的时候 因为是 bst + inOrder 第一个大的element 已经找到了 -> first = prev
            //            那么 第二个 就应该是cur 因为 prev.val > cur.val 是错误的  prev.val 应该小于 cur.val
            second = root;
        }
        prev = root;
        inOrder(root.right);
    }

}
