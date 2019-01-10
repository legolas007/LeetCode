package math;

import java.util.TreeMap;

/**
 * @Author: Usher
 * @Date: 2019/1/9/0009
 * @Description:
 * binary search
 *
 */
public class RandomPickwithWeight {
    //private int[] sum;
    private int cnt = 0;
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public RandomPickwithWeight(int[] w) {
        /*sum = w;
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }*/
        for (int i = 0; i < w.length; i++) {
            cnt += w[i];
            treeMap.put(cnt, i);
        }

    }

    public int pickIndex() {
        int randPick = (int) (Math.random() * cnt % cnt);

        int key = treeMap.higherKey(randPick);
        return treeMap.get(key);
    }
}
