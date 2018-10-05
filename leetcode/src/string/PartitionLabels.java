package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int start = 0, last = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i < S.length();i++)
            map.put(S.charAt(i),i);
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map.get(S.charAt(i)));
            if (i == last) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
