package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Usher
 * @Description:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    f[j]是上一个匹配的位置
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] f = new boolean[s.length() +1];
        f[0] = true;

        for (int i =1;i <= s.length();i++){
            for (int j=0;j < i;j++){
                if (f[j] && dict.contains(s.substring(j,i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
