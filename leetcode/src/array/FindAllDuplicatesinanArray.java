package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 对于每个nums[i]，我们将其对应的nums[nums[i] - 1]取相反数，如果其已经是负数了，说明之前存在过，我们将其加入结果res中
 *
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                res.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }
        return res;
    }
}
