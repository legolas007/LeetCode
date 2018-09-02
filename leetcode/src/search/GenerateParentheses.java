package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 当左括号出现次数<n时，可以放置新的左括号，
 * 当右括号出现次数小于左括号出现次数时，可以放置新的右括号
 *
 * 递归
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if (n > 0)
            match(n, path, result, 0, 0);
        return result;
    }

    private void match(int n, StringBuilder path, List<String> result, int l, int r) {
        if (l == n) {
            StringBuilder stringBuilder = new StringBuilder(path);
            for (int i =0;i < n-r;i++)
                stringBuilder.append(')');
            result.add(stringBuilder.toString());
            return;
        }

        path.append('(');
        match(n, path, result, l + 1, r);
        //backtracking
        path.deleteCharAt(path.length() - 1);

        if (l > r) {
            path.append(')');
            match(n, path, result, l, r + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
