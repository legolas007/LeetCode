package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 全排列
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]

 */
public class PermutationsII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums,list,visited);
        return res;
    }
    public void backtracking(int[] nums,List<Integer> list,boolean[] visited){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i < nums.length;i++){
            //判断这个元素是否等于前一个元素，如果等于，
            // 并且前一个元素还未访问，那么就跳过这个元素。
            if (i!=0&&nums[i] == nums[i-1]&&!visited[i-1])
                continue;
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            backtracking(nums,list,visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
