package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/7/20,0020
 * @Description:
 */
public class ArrayofDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.merge(A[i], 1, Integer::sum);
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]) && map.get(A[i]) > 0 && map.containsKey(2 * A[i]) && map.get(2 * A[i]) > 0) {
                map.put(A[i], map.get(A[i]) - 1);
                map.put(2 * A[i], map.get(2 * A[i]) - 1);
            }else if (A[i] % 2 ==0 && map.containsKey(A[i]) && map.get(A[i]) > 0 && map.containsKey( A[i]/2) && map.get(A[i]/2) > 0) {
                map.put(A[i], map.get(A[i])-1);
                map.put(A[i]/2, map.get( A[i]/2) - 1);
            }
        }

        for (int value : map.values()) {
            if (value > 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canReorderDoubled2(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Integer[] b = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            b[i] = A[i];
        }
        //包装对象类型，不不能是基本类型
        Arrays.sort(b, Comparator.comparingInt(Math::abs));
        for (Integer integer : b) {
            if (map.containsKey(integer)) {
                if (map.containsKey(integer * 2)) {
                    int cur1 = map.get(integer) - 1;
                    int cur2 = map.get(integer * 2) - 1;
                    if (cur1 == 0) {
                        map.remove(integer);
                    } else {
                        map.put(integer, cur1);
                    }
                    if (cur2 == 0) {
                        map.remove(integer * 2);
                    } else {
                        map.put(integer * 2, cur2);
                    }
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
