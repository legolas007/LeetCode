package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/31/0031
 * @Description:
 * 蓄水池抽样：
 * 我们总是选择第一个对象，以1/2的概率选择第二个，以1/3的概率选择第三个，以此类推，以1/m的概率选择第m个对象。当该过程结束时，每一个对象具有相同的选中概率，即1/n
 *
 */
public class Solution {


    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
