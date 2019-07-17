package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/07/14,0014
 * @Description:
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }

        int[] res = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.merge(arr1[i], 1, Integer::sum);
        }

        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int k = 0; k < map.get(arr2[i]); k++) {
                res[j++] = arr2[i];
            }
        }
        Arrays.sort(arr1);
        for (int num : arr1) {
            if (!set.contains(num))
                res[j++] = num;
        }
        return res;
    }
}
