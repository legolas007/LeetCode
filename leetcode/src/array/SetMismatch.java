package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/7/20,0020
 * @Description:
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            set.add(nums[i]);
            if (nums[i] == nums[i + 1]) {
                res[0] = nums[i];
            }
        }
        set.add(nums[nums.length - 1]);

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
