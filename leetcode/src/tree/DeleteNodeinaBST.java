package tree;

/**
 * @Author: Usher
 * @Description:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */

public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        // 如果值root.val != key，递归查找
        if (key > root.val){
            root.right = deleteNode(root.right, key);
        }else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }else {
            // 左子树为空则直接返回右子树，右子树为空则直接返回左子树
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //右边最小的
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            // 继续删除已经被复制了的右孩子
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}

