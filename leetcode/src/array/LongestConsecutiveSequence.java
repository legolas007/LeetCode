package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Usher
 * @Description: Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;

        Set<Integer> numSet = new HashSet<>();
       // Arrays.sort(arr);

        for (int num : arr) {
            numSet.add(num);
        }

        int max = 1;
        while (!numSet.isEmpty()) {
            int range = 1;
            int num = numSet.iterator().next();

            numSet.remove(num);
            for (int i = 1; ; i++) {
                if (numSet.remove(num + i))
                    range++;
                else break;
            }

            for (int i = 1; ; i++) {
                if (numSet.remove(num - i))
                    range++;
                else break;
            }
            max = Math.max(max, range);
        }
        return max;

    }

    public int longestConsecutive2(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}

