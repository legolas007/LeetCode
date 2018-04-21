package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
[1, 7],
[1, 2, 5],
[2, 6],
[1, 1, 6]
]
 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtracking(candidates,target,0,list,visited);
        return res;
    }
    public void backtracking(int[] candidates,int target,int s,List<Integer> list,boolean[] visited){
        if (target < 0)
            return;
        if (target == 0){
            res.add(new ArrayList<>(list));
        }else {
            for (int i = s; i < candidates.length; i++) {
                if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1])
                    continue;
                if (visited[i])
                    continue;
                if (target < candidates[i])
                    return;//剪枝
                visited[i] = true;
                list.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
