package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/4/27/0027
 * @Description:
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {

        int res = Integer.MAX_VALUE, diff = 0, n = timePoints.size();
        timePoints.sort(String::compareTo);
        for (int i = 0; i < timePoints.size(); i++) {

            String t1 = timePoints.get(i), t2 = timePoints.get((i + 1) % n);
            int h1 = (t1.charAt(0) - '0') * 10 + t1.charAt(1) - '0';
            int m1 = (t1.charAt(3) - '0') * 10 + t1.charAt(4) - '0';

            int h2 = (t2.charAt(0) - '0') * 10 + t2.charAt(1) - '0';
            int m2 = (t2.charAt(3) - '0') * 10 + t2.charAt(4) - '0';
            diff = (h2 - h1) * 60 + (m2 - m1);
            //第一个和末尾的时间点进行比较，第一个时间点需要加上24小时再做差值
            if (i == n - 1)
                diff += 24 * 60;
            res = Math.min(res, diff);
        }
        return res;
    }

    public int findMinDifference2(List<String> timePoints) {
        int n = timePoints.size();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            nums[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }

        Arrays.sort(nums);
        //第一个和末尾的时间点进行比较，第一个时间点需要加上24小时再做差值
        int ret = 24 * 60 + nums[0] - nums[n - 1];
        for (int i = 1; i < n; i++)
            ret = Math.min(ret, nums[i] - nums[i - 1]);

        return ret;
    }
}
