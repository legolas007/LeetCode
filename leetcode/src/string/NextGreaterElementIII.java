package string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/3/16/0016
 * @Description:
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i)-'0';
        }
        Arrays.sort(nums);

        List<String> res = permuteUnique(nums, s);
        //return bigInteger.intValue();
        return res.size() != 0 ? new BigInteger(res.get(0)).intValue() : -1;
    }

    public List<String> permuteUnique(int[] nums,String s) {
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(), used, nums,s);
        return res;
    }

    public void backtracking(List<String> res, List<Integer> temp, boolean[] used, int[] nums,String s) {
        if (temp.size() == nums.length) {


            StringBuilder stringBuilder = new StringBuilder();
            for(int i : temp) {
                stringBuilder.append(i);
            }
            if (stringBuilder.toString().compareTo(s)>0) {
                if (res.size() > 0 && stringBuilder.toString().compareTo(res.get(0))<0) {
                    res.remove(0);
                }
                res.add(stringBuilder.toString());

            }

        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
                temp.add(nums[i]);
                used[i] = true;
                backtracking(res, temp, used, nums,s);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }

        }
    }
}
