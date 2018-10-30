package tree;

/**
 * @Author: Usher
 * @Description:
 */
public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSameStructure(s.left,t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameStructure(TreeNode s,TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;
        return isSameStructure(s.left, t.left) && isSameStructure(s.right, t.right);
    }
}
