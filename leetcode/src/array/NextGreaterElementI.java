package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/06/29,0029
 * @Description:
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        if (nums1.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length-1; i++) {
            int j = i+1;
            while (j < nums2.length) {
                if (nums2[i] > nums2[j]) {
                    j++;
                } else {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }

            if (j == nums2.length) {
                map.put(nums2[i], -1);
            }
        }

        map.put(nums2[nums2.length - 1], -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
