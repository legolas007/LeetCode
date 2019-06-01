package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/6/1/0001
 * @Description:
 */
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        int longest = 1;

        Map[] f = new Map[n];

        //Arrays.fill(f, new HashMap<Integer, Integer>());
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Integer, Integer>();
        }

        for (int j = 1; j < n; ++j) {
            for (int k = 0; k < j; ++k) {

                int diff = A[j] - A[k];
                int curt = (int) f[j].getOrDefault(diff, 1);
                int target = (int) f[k].getOrDefault(diff, 1);

                if (curt <= target) {
                    f[j].put(diff, target + 1);
                    longest = Math.max(longest, target + 1);
                }
            }
        }

        return longest;
    }

    //base
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
