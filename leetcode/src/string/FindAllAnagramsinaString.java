package string;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash

        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //初始化p的长度
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //如果p里包含
            if (hash[s.charAt(right++)]-- >= 1) count--;

            if (count == 0) list.add(left);
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //如果前一段p遍历完，继续下一个遍历，如果p包含，count++
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    /*public  static List<Integer> findAnagrams(String s, String p) {
        List<String> reStrings = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        PermutationHelper(p.toCharArray(), 0, reStrings);
        for (String string : reStrings) {
            for (int i = 0; i <= s.length()-p.length(); i++) {
                if (s.substring(i, i + p.length()).equals(string) && (i+p.length() <= s.length())) {
                    list.add(i);
                }
            }
        }
        return list;


    }
    //全排列，爆栈
    private static void PermutationHelper(char[] charArray, int i, List<String> reStrings) {

        // i号位置作为交换点，向后交换
        // 递归出口：只剩一个字符，即无法交换
        if (charArray.length - 1 == i) {
            reStrings.add(String.valueOf(charArray));
        } else {
            for (int j = i; j < charArray.length; ++j) {
                // 依次交换i与它后边的每一个字符
                if (j == i || charArray[j] != charArray[i]) {// 去重复值，除了i位置与自己交换的情况
                    swap(charArray, i, j);
                    PermutationHelper(charArray, i + 1, reStrings);// 对后面所有的字符进行全排列
                    swap(charArray, i, j);// 再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
                }
            }
        }

    }

    private static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }*/


}
