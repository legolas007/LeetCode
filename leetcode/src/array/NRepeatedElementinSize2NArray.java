package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/1/17/0017
 * @Description:
 */
public class NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.merge(a, 1, Integer::sum);
            if (map.get(a) == A.length / 2) {
                return a;
            }
        }
        return -1;

    }
}
