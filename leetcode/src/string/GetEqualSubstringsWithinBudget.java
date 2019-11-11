package string;

/**
 * @Author: Usher
 * @Date: 2019/10/6,0006
 * @Description:
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int cnt = 0, left = 0, right = 0;
        while (right < s.length()) {
            int diff = Math.abs(s.charAt(right) - t.charAt(right));
            if (maxCost - diff >= 0) {
                right++;
                maxCost -= diff;
            } else {
                cnt = Math.max(cnt, right - left);
                maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }
        return Math.max(cnt, right - left);
    }
}
