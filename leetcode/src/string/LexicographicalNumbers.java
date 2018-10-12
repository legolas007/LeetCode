package string;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(i + 1));
        }

        Collections.sort(list);

        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            result.add(Integer.valueOf(s));
        }
        /*List<Integer> result = new ArrayList<>();
        for (int i=1;i <= n;i++)
            result.add(i);
        Collections.sort(result, Comparator.comparing(String::valueOf));*/
        return result;
    }

    public List<Integer> lexicalOrder2(int n) {
        //Edge case
        if(n <= 0) return new ArrayList<Integer>();
        //DFS problem
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
            dfs(i, n, result);
        return result;
    }

    public void dfs(int start, int n, List<Integer> result) {
        // Base case
        if(start > n)
            return;
        result.add(start);
        start *= 10;
        for(int i = 0; i <= 9; i++)
            dfs(start + i, n, result);
    }
}
