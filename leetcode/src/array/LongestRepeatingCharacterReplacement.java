package array;

/**
 * @Author: Usher
 * @Description:
 * 满足(子字符串的长度减去出现次数最多的字符个数)<=k的最大子字符串长度即可，
  * 用滑动窗口来解,用一个变量start记录滑动窗口左边界，初始化为0，然后遍历字符串，每次累加出现字符的个数，然后更新出现最多字符的个数，
   * 然后判断当前滑动窗口是否满足之前说的那个条件，如果不满足，就把滑动窗口左边界向右移动一个，去掉的字符要在counts里减一，直到满足条件
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int result = 0, maxCnt = 0, start = 0;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            maxCnt = Math.max(maxCnt, ++counts[s.charAt(i) - 'A']);
            while (i - start + 1 - maxCnt > k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
