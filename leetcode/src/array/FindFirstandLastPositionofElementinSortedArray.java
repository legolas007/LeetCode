package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
                flag = false;
            }
        }

        if (flag) {
            return new int[]{-1, -1};
        } else {
            List<Integer> res = new ArrayList<>();
            if (list.size() == 1) {
                return new int[]{list.get(0),list.get(0)};
            } else if (list.size() >= 2) {
                res.add(list.get(0));
                res.add(list.get(list.size() - 1));
            }

            return new int[]{res.get(0),res.get(1)};
        }
    }
}
