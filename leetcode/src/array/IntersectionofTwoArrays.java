package array;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                res.add(num);
            }
        }
        int[] a = new int[res.size()];
        int i = 0;
        for (int num : res) {
            a[i++] = num;
        }
        return a;
    }
}
