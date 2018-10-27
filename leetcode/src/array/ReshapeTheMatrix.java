package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        //List<Integer> list = new ArrayList<>();
        int[] tmp = new int[nums.length * nums[0].length];
        int idx = 0;
        for (int[] a : nums) {
            for (int num : a) {
                //list.add(num);
                tmp[idx++] = num;
            }
        }
        int[][] res = new int[r][c];
        idx = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                //res[i][j] = list.get(idx++);
                res[i][j] = tmp[idx++];
            }
        }
        return res;
    }
}
