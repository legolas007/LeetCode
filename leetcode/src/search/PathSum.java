package search;

import java.util.ArrayList;

/**
 * @Author: Usher
 * @Description:
 * Given the below binary tree and sum = 22,

5
/ \
4   8
/   / \
11  13  4
/  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public boolean FindPath(TreeNode root, int target) {
        backtracking(root,target,new ArrayList<>());
        if (ret.size() > 0)
            return true;
        return false;
    }

    private void backtracking(TreeNode node,int target,ArrayList<Integer> path){
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;

        if (target == 0&& node.left == null&&node.right == null)
            ret.add(new ArrayList<>(path));
        else{
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }
        path.remove(path.size()-1);
    }
}
