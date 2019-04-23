package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/4/20/0020
 * @Description:
 */
public class RandomFlipMatrix {
    private int row, col;
    private Set<Integer> set;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        row = n_rows;
        col = n_cols;
        set = new HashSet<>();
    }

    public int[] flip() {
        while (true) {
            int x = (int) (Math.random() * row);
            int y = (int) (Math.random() * col);

            if (!set.contains(x * col + y)) {
                set.add(x * col + y);
                return new int[]{x, y};
            }
        }
    }

    public void reset() {
        set.clear();
    }
}
