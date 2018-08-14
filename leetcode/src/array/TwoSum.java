package array;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i =0 ;i< nums.length;i++){
            for (int j = i+1;j <nums.length;j++){
                if ( nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    public int[] twoSum2(int[] nums, int target) {
        //int[] arr = new int[2];
        HashMap<Integer, Integer> onePass = new HashMap<>();
        onePass.put(nums[0], 0);
        int difference;
        for(int i = 1; i < nums.length; i++) {
            difference = target - nums[i];
            if (onePass.containsKey(difference)) {
                return new int[]{onePass.get(difference), i};
            } else {
                onePass.put(nums[i], i);
            }
        }

        return new int[]{0,0};
    }
}
