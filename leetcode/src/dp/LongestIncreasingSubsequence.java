package dp;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 * 递推公式F[1] = 1,F[i] = max{1,F[j]+1|aj<ai&&j<i}
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i =1;i < nums.length;i++){
            f[i] = 1;
            for (int j =0;j < i;j++){
                if (nums[i] > nums[j])
                    f[i] = Math.max(f[i],f[j]+1);
            }
        }

        Arrays.sort(f);
        return f[nums.length-1];
    }
}
