package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/4/27/0027
 * @Description:
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> endsList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            List<Integer> list = new ArrayList<>(Collections.singletonList(nums[i]));
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && endsList.get(j).size() + 1 > list.size()) {
                    list = new ArrayList<>(endsList.get(j));
                    list.add(nums[i]);
                }
            }

            res = list.size() > res.size() ? list : res;
            endsList.add(list);
        }
        return res;
    }
}
