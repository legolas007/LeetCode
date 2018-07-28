package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {

        String[] d = new String[]{" ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        //一个组合
        char[] cur = new char[digits.length()];
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return new ArrayList<>();

        dfs(digits, d, 0, cur, ans);
        return ans;
    }

    private void dfs(String digits, String[] d, int l, char[] cur, List<String> ans) {
        //搜索完，添加ans
        if (digits.length() == l) {
            ans.add(new String(cur));
            return;
        }
        //数字对应的字母
        String s = d[Character.getNumericValue(digits.charAt(l))];

        for (int i = 0; i < s.length(); i++) {
            //一个组合，添加字母集合
            cur[l] = s.charAt(i);
            dfs(digits, d, l+1, cur, ans);
        }
    }
}
