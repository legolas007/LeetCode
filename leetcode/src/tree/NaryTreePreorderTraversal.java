package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/2/23/0023
 * @Description:
 */
public class NaryTreePreorderTraversal {
    List<Integer> res;
    public List<Integer> preorder(Node root) {

        res = new ArrayList<>();
        if (root == null)
            return res;

        treePreOrder(root);
        return res;
    }

    void treePreOrder(Node root) {
        if (root == null)
            return;

        res.add(root.val);
        root.children.forEach(this::treePreOrder);
}
}
