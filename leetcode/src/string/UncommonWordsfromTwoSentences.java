package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/1/31/0031
 * @Description:
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] strings = A.split(" ");
        for (String s : strings) {
            map.merge(s, 1, Integer::sum);
        }

        strings = B.split(" ");

        for (String s : strings) {
            map.merge(s, 1, Integer::sum);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }


        return list.toArray(new String[list.size()]);
    }
}
