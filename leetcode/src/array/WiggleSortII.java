package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/2/6/0006
 * @Description:
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] res = new int[nums.length];

        int k = 0, n = nums.length;
        for (int i = (nums.length+1) / 2; i >=0; i--) {
            res[k++] = nums[i];
            if (k == nums.length)
                break;
            res[k++] = nums[n--];
        }

        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}
