package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/21/0021
 * @Description:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows < 1) {
            return res;
        }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
