package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class PathSumII {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        backtracking(root,sum,new ArrayList<>());
        return ret;
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
