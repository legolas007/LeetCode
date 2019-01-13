package greedy;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/1/12/0012
 * @Description:
 * Input: "cbacdcbc"
 * Output: "acdb"
 *
 * 建立一个哈希表来统计每个字母出现的次数，还需要一个visited数字来纪录每个字母是否被访问过，我们遍历整个字符串，
 * 对于遍历到的字符，先在哈希表中将其值减一，然后看visited中是否被访问过，若访问过则继续循环，说明该字母已经出现在结果中并且位置已经安排妥当。
 * 如果没访问过，我们和结果中最后一个字母比较，如果该字母的ASCII码小并且结果中的最后一个字母在哈希表中的值不为0(说明后面还会出现这个字母)，
 * 那么我们此时就要在结果中删去最后一个字母且将其标记为未访问，然后加上当前遍历到的字母，并且将其标记为已访问，以此类推直至遍历完整个字符串s，
 * 此时结果里的字符串即为所求。这里有个小技巧，我们一开始给结果字符串res中放个"0"，就是为了在第一次比较时方便，
 * 如果为空就没法和res中的最后一个字符比较了，而‘0’的ASCII码要小于任意一个字母的
 *
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] hash = new int[26];
        int[] visited = new int[26];
        StringBuilder res = new StringBuilder("0");
        for (Character c : s.toCharArray()) {
            hash[c - 'a']++;
        }


        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']--;

            if (visited[s.charAt(i) - 'a'] != 0)
                continue;

            while (s.charAt(i) < res.charAt(res.length() - 1) &&
                    hash[res.charAt(res.length() - 1) - 'a'] != 0) {
                visited[res.charAt(res.length() - 1) - 'a'] = 0;
                res.deleteCharAt(res.length() - 1);
            }

            res.append(s.charAt(i));
            visited[s.charAt(i) - 'a'] = 1;
        }
        return res.substring(1);



    }
}
