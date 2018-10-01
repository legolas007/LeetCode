package search;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class IncreasingSubsequences {
    private Set<List<Integer>> set = new HashSet<>();
    public  List<List<Integer>> findSubsequences(int[] nums) {
       List <Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, list);
        return new ArrayList<>(set);

    }

    private  void helper(int[] nums, int start, List<Integer> list) {
        if (list.size() >= 2) {
            set.add(new ArrayList<>(list));//set.add(list);同一个list，重复，覆盖为空
        }
        for (int i = start; i < nums.length; i++) {
            if (!list.isEmpty() && list.get(list.size() - 1) > nums[i]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


}
