package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);

        int[] v = new int[k];
        return helper(nums, sum / k, v, nums.length - 1);
    }

    boolean helper(int[] nums, int target, int[] v,int idx){
        if (idx == -1) {
            for (int t : v) {
                if (t != target)
                    return false;
            }
            return true;
        }

        int num = nums[idx];
        for (int i = 0; i < v.length; i++) {
            if (v[i] + num > target)
                continue;
            v[i] += num;
            if (helper(nums,target,v,idx-1))
                return true;
            v[i] -= num;
        }
        return false;
    }
    public  boolean canPartitionKSubsets2(int[] nums, int k) {

        int total = 0;
        for (int num : nums) { total += num; }
        int target = total / k;
        if (total % k != 0 || k <= 0 || k > nums.length) { return false; }

        return canPartitionKHelper(nums, new boolean[nums.length], 0, target, k, 0, 0);
    }

    private static boolean canPartitionKHelper(int[] nums, boolean[] visited, int startIdx, int target, int k, int crtSum, int crtNum) {
        if (k == 1) { return true; }
        if (crtSum == target && crtNum > 0) { return canPartitionKHelper(nums, visited, 0, target, k - 1, 0, 0); }
        for (int i = startIdx; i < nums.length; i++) {
            if (!visited[i]) {
                if(crtSum + nums[i] > target){ /** optimize here */
                    continue;
                }
                visited[i] = true;
                if(canPartitionKHelper(nums, visited, i + 1, target, k, crtSum + nums[i], crtNum++)) { return true;
                } /** startIdx should be i + 1*/
                visited[i] = false;
            }
        }
        return false;
    }
}
