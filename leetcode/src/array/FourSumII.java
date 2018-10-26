package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 * 把A和B的两两之和都求出来，在哈希表中建立两数之和跟其出现次数之间的映射，
 * 那么我们再遍历C和D中任意两个数之和，我们只要看哈希表存不存在这两数之和的相反数就行了
 *
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int aA : A) {
            for (int aB : B) {
                map.merge(aA + aB, 1, Integer::sum);
            }
        }
        for (int cC : C) {
            for (int dD : D) {
                int target = -1 * (cC + dD);
                if (map.containsKey(target)) {
                    result += map.get(target);
                }
            }
        }
        return result;
    }
}
