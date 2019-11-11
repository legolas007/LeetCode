package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/10/6,0006
 * @Description:
 * Let dp[i] be the maximum length of a subsequence of
 * the given difference whose last element is i.
 *
 * dp[i] = 1 + dp[i-k]
 */
public class LongestArithmeticSubsequenceofGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - difference)) {
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            }

            map.put(arr[i], i);
        }
        Arrays.sort(dp);

        return dp[arr.length - 1];
    }

    public int solution(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;

        for (int value : arr) {
            if (map.containsKey(value)) {
                int val = map.get(value);
                maxLength = Math.max(maxLength, val + 1);
                map.put(value + difference, val + 1);
            } else map.put(value + difference, 1);
        }
        return maxLength;
    }
}
