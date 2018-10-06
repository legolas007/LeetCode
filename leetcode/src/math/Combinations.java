package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(1, n, k, list, result);
        return result;
    }

    public void backtracking(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            backtracking(i + 1, n, k - 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
