package array;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Map<Integer, List<int[]>> twoSumMap = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 1 && nums[i] == nums[i - 2]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 2 && nums[j] == nums[j - 2]) continue;
                if (twoSumMap.containsKey(target - (nums[i] + nums[j]))) {
                    List<int[]> ls = twoSumMap.get(target - (nums[i] + nums[j]));

                    for (int[] pair : ls) {
                        int m1 = Math.min(pair[0], i);
                        int m2 = Math.min(pair[1], j);
                        int m3 = Math.max(pair[0], i);
                        int m4 = Math.max(pair[1], j);
                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;

                        res.add(Arrays.asList(nums[m1], nums[Math.min(m2, m3)], nums[Math.max(m2, m3)], nums[m4]));
                    }
                }

                twoSumMap.computeIfAbsent(nums[i] + nums[j], key -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        return new ArrayList<>(res);

    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int k = 0; k < nums.length - 3; k++) {
            for (int i = k+1; i < nums.length-2; i++) {
                if (i > k+1 && nums[i] == nums[i-1])
                    continue;

                int start = i + 1, end = nums.length - 1, sum = 0;
                while (start < end) {
                    sum = nums[start] + nums[end] + nums[k] + nums[i];
                    if (target == sum) {
                        lists.add(Arrays.asList(nums[k],nums[i], nums[start], nums[end]));
                        ++start;
                        --end;
                    } else if (sum < target) {
                        ++start;
                    } else {
                        --end;
                    }
                }
            }

        }
        return lists;

    }
}
