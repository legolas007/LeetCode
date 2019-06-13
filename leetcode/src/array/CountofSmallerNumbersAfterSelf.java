package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/6/12/0012
 * @Description:
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 */
public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }

            list.add(count);
        }
        return list;
    }
}
