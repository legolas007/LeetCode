package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2018/12/20/0020
 * @Description:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 *
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 */
public class PopulatingNextRightPointersinEachNode {
    public static void connect(TreeLinkNode root) {

        if (root == null)
            return;
        if (root.left != null)
            root.left.next = root.right;
        if (root.right !=null)
            root.right.next = root.next == null ? null : root.next.left;

        connect(root.left);
        connect(root.right);
    }
}
