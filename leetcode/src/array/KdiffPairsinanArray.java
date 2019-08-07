package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/7/20,0020
 * @Description:
 */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {

        int cnt = 0;
        if (k >0) {
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (set.add(nums[i])) {
                    if (set.contains(nums[i] + k)) {
                        cnt++;
                    }
                    if (set.contains(nums[i] - k)) {
                        cnt++;
                    }
                }
            }

            /*for (int num1 : set) {
                if (set.contains(num1 + k)) {
                    cnt++;
                }
            }*/

        } else if(k ==0){
            Arrays.sort(nums);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length-1; i++) {
                if (!set.contains(nums[i]) && nums[i] == nums[i + 1]) {
                    cnt++;
                    set.add(nums[i]);
                }
            }
        }
        return cnt;
    }
}
