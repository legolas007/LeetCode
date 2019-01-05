package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/1/5/0005
 * @Description:
 */
public class MinimumWindowSubstring {

    //Time Limit Exceeded
    public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        if (s.length() < t.length())
            return "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1 ; j <= s.length(); j++) {

                String tmp = s.substring(i, j);
                Map<Character, Integer> map = new HashMap<>();
                for (int k = 0; k < tmp.length(); k++) {
                    map.merge(tmp.charAt(k), 1, Integer::sum);
                }
                boolean flag = true;
                for (int k = 0; k < t.length(); k++) {
                    if (map.containsKey(t.charAt(k)) && map.get(t.charAt(k)) != 0) {
                        map.put(t.charAt(k), map.get(t.charAt(k)) - 1);
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    if (res.equals("")) {
                        res = tmp;
                    } else {
                        if (tmp.length() < res.length()) {
                            res = tmp;
                        }
                    }

                }
            }
        }
        return res;
    }
    public String minWindow2(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }


        int required = dictT.size();
        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0};

        while (r < s.length()) {

            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}
