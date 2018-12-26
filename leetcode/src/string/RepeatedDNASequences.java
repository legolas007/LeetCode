package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2018/12/26/0026
 * @Description:
 */
public class RepeatedDNASequences {
    List<String> res;
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        } else if (s.length() == 10) {
            res = new ArrayList<>();
            res.add(s);
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
         res = new ArrayList<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            if (map.containsKey(tmp)) {
                if (!res.contains(tmp))
                    res.add(tmp);
            } else {
                map.put(tmp, 1);
            }
        }
        return res;
    }
}
