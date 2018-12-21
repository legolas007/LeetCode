package tree;

/**
 * @Author: Usher
 * @Date: 2018/12/20/0020
 * @Description:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {

        if(root == null)
            return;

        if(root.left != null) {
            root.left.next = root.right !=null ? root.right : findNextNode(root);
        }
        if(root.right != null)
            root.right.next = findNextNode(root);
        connect(root.right);
        connect(root.left);
    }


    private TreeLinkNode findNextNode(TreeLinkNode root) {

        while(root.next != null) {
            root = root.next;
            if(root.left != null) return root.left;
            if(root.right != null) return root.right;
        }
        return null;
    }
}
