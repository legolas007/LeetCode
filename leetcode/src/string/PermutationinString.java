package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Descris2tion:
 */
public class PermutationinString {
    public boolean checkInclusion( String s2,String s1) {
        List<Integer> list = new ArrayList<>();

        int[] hash = new int[256]; //character hash

        for (char c : s2.toCharArray()) {
            hash[c]++;
        }
        //初始化s2的长度
        int left = 0, right = 0, count = s2.length();
        while (right < s1.length()) {
            //如果s1里包含
            if (hash[s1.charAt(right++)]-- >= 1) count--;

            if (count == 0) return true;
            if (right - left == s2.length() && hash[s1.charAt(left++)]++ >= 0) count++;
        }
        return false;
    }
}
