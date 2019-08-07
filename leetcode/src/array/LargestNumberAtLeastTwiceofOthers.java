package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/7/27,0027
 * @Description:
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int idx = -1;
        for(int i =0; i < nums.length; i++) {
            if(nums[i] > maxNum) {
                idx = i;
                maxNum = nums[i];
            }

        }

        for(int num: nums) {
            if( num != maxNum && maxNum < num*2 ) return -1;
        }
        return idx;
    }
}
