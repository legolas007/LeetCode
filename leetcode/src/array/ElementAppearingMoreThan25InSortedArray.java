package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/12/22,0022
 * @Description:
 */
public class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }


        for (Map.Entry entry : map.entrySet()) {
            if ( (int) (entry.getValue())/(arr.length*1.0) > 0.25) {
                return (int)entry.getKey();
            }
        }
        return 0;
    }
}
