package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2018/12/21/0021
 * @Description:
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= rowIndex; i++) {
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
        return res.get(rowIndex-1);
    }
}
