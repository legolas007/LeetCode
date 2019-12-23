package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/12/22,0022
 * @Description:
 */
public class DivideArrayinSetsofKConsecutiveNumbers {
    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        Arrays.sort(nums);


        int[] arr = new int[k];
        arr[0] = nums[0];
        nums[0] = Integer.MIN_VALUE;
        int flag = 0, i = 0, res = 0;
        while (++i <= n) {
            if (flag + 1 == k) {
                i = 0;
                flag = 0;
                ++res;
                Arrays.fill(arr, 0);
                arr[0] = help(nums);
                if (arr[0] == Integer.MIN_VALUE) {
                    break;
                }
            }


            if (i == n) {
                continue;
            }

            if (nums[i] - arr[flag] == 1) {
                arr[++flag] = nums[i];
                nums[i] = Integer.MIN_VALUE;
            }
        }
        return res == n / k;
    }

    private static int help(int[] nums) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                res = nums[i];
                nums[i] = Integer.MIN_VALUE;
                break;
            }
        }
        return res;
    }

    public static boolean isPossibleDivide2(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            if (map.get(num) > 0) {
                for (int i = 0; i < k; i++) {
                    if (!map.containsKey(num + i) || map.get(num + i) == 0) {
                        return false;
                    } else {
                        map.put(num + i, map.get(num + i) - 1);
                    }
                }
            }
        }
        return true;
    }
}
