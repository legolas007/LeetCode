package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
[2],
[1],
[1,2,2],
[2,2],
[1,2],
[]
]
 */
public class SubsetsII {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i <= nums.length;i++){
            backtracking(nums,i,0,list);
        }
        return res;
    }
    public void backtracking(int[] nums,int k,int s,List<Integer> list){
        if (k<0)
            return;
        else if (k == 0)//已经找到了k个数字的组合，加入全局res
            res.add(new ArrayList<Integer>(list));
        else {
            for (int j = s;j < nums.length;j++){
                if (j != s&& nums[j] == nums[j-1])//跳过dup
                    continue;
                list.add(nums[j]);//尝试加入
                //开始回溯，下次要找的数字减少一个k-1
                backtracking(nums,k-1,j+1,list);
                /**
                 * 每次找到了1,2这一对答案以后，下一次希望2退出然后让3进来，
                 * 1 3就是我们要找的下一个组合。如果不回退，找到了2 ，3又进来，找到了3，4又进来，所以就出现了错误答案
                 *
                 */
                //回退，每次清除一个空位 让后续元素加入。寻找成功，最后一个元素要退位，寻找不到，
                // 方法不可行，那么我们回退，也要移除最后一个元素
                list.remove(list.size()-1);
            }
        }
    }
}
