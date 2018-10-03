package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if(len == 1 || nums[1] != nums[0]) return nums[0];
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[i-1])
                if(i == len - 1)
                    return nums[i];
                else if(i % 3 != 0)
                    return nums[i-1];
        }
        return -1;
    }
}
