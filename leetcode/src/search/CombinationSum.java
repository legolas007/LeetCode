package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
[7],
[2,2,3]
]
 */
public class CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtracking(candidates,target,0,list);
        return res;
    }
    public void backtracking(int[] candidates,int target,int s,List<Integer> list){
        if (target < 0)
            return;
        if (target == 0){
            res.add(new ArrayList<>(list));
        }else {
            for(int i = s;i < candidates.length;i++){
                if (target < candidates[i])
                    return;//剪枝
                list.add(candidates[i]);
                backtracking(candidates,target-candidates[i],i,list);
                list.remove(list.size()-1);
            }
        }
    }
}
