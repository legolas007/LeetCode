package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/29/0029
 * @Description:
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;
        if (n == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {

            if (i != n-1 && nums[i] == nums[i + 1] - 1  ) {
                ++count;
            } else {
                if (count < 1) {
                    res.add(String.valueOf(nums[i]));
                    count = 0;
                } else {
                    String s;
                    s = nums[i - count] + "->" + nums[i];
                    res.add(s);
                    count = 0;
                }
            }

        }
        return res;
    }
}
