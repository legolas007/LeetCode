package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/1/7/0007
 * @Description:
 */
public class RemoveInvalidParentheses {


    public List<String> removeInvalidParentheses(String s) {
        Deque<String> deque = new ArrayDeque<>();
        deque.offer(s);

        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        boolean flag = false;
        while (!deque.isEmpty()) {
            String tmp = deque.poll();
            if (isValid(tmp)) {
                res.add(tmp);
                flag = true;
            }
            if (flag)
                continue;


            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) != '(' && tmp.charAt(i) != ')')
                    continue;

                String str = tmp.substring(0, i) + tmp.substring(i + 1);
                if (!visited.contains(str)) {
                    deque.offer(str);
                    visited.add(str);
                }

            }
        }
        return res;
    }


    boolean isValid(String t) {
        int cnt = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (t.charAt(i) == '(') ++cnt;
            else if (t.charAt(i) == ')' && --cnt < 0) return false;
        }
        return cnt == 0;
    }
}
