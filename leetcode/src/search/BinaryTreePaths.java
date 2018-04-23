package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

1
/   \
2     3
\
5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root,"",res);
        return res;
    }
    private void dfs(TreeNode root,String prefix,List<String> res){
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            res.add(prefix + root.val);
            return;
        }
        prefix += (root.val + "->");
        dfs(root.left,prefix,res);
        dfs(root.right,prefix,res);
    }
}
