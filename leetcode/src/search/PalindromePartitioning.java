package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 首先从第一个隔板开始挨个往后取，若取到的子串不是回文则立即取下一个隔板，直到取到最后一个隔板。若取到的子串是回文，则将当前子串加入临时列表中，接着从当前隔板处字符开始递归调用回溯函数，直至取到最后一个隔板，最后将临时列表中的子串加入到最终返回结果中。接下来则将临时列表中的结果一一移除
 *
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.isEmpty()) return result;

        List<String> palindromes = new ArrayList<String>();
        dfs(s, 0, palindromes, result);

        return result;
    }

    private void dfs(String s, int pos, List<String> palindromes, List<List<String>> ret) {
        if (pos == s.length()) {
            ret.add(new ArrayList<>(palindromes));
            return;
        }

        for (int i = pos + 1;i <= s.length();i++){
            String subStr = s.substring(pos, i);
            if (!isPalindrome(subStr)) {
                continue;
            }

            palindromes.add(subStr);
            dfs(s, i, palindromes, ret);
            palindromes.remove(palindromes.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;
    }
}
