package array;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Author: Usher
 * @Date: 2019/6/8/0008
 * @Description:
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        long diff = Long.MAX_VALUE;
        if (nums.length > k) {
            int[] slice = new int[k + 1];
            for (int i = 0; i < nums.length - k; i++) {
                int j = i, l = 0;

                while (j <= i + k && j < nums.length) {
                    slice[l++] = nums[j++];
                }

                Arrays.sort(slice);
                for (j = 1; j < slice.length; j++) {
                    diff = Math.min(diff, Math.abs(((long) slice[j] - (long) slice[j - 1])));
                }
            }
        } else {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                diff = Math.min(diff, Math.abs((long) nums[i] - (long) nums[i - 1]));
            }
        }

        return diff <= t;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0)
            return false;

        if (k < 0 || t < 0)
            return false;

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = treeSet.ceiling(nums[i]);

            if (ceiling != null && ceiling <= nums[i] + t)
                return true;

            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && nums[i] <= floor + t)
                return true;

            treeSet.add(nums[i]);

            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
