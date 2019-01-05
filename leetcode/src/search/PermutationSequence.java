package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/1/4/0004
 * @Description:
 */
public class PermutationSequence {
    int count = 0;
    List<List<Integer>> res = new ArrayList<>();

    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backTracking(n, list, visited, k);

        StringBuilder sb = new StringBuilder();

        for (int num : res.get(0)) {
            sb.append(num);
        }

        return sb.toString();
    }

    void backTracking(int n, List<Integer> list, boolean[] visited, int k) {
        if (list.size() == n) {
            // res.add(new ArrayList<>(list));
            count++;
            if (count == k)
                res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (count == k)
                break;
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(i + 1);
            backTracking(n, list, visited, k);
            visited[i] = false;
            list.remove(list.size() - 1);
        }

    }
}
