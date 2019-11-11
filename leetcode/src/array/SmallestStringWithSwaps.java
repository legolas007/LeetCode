package array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Usher
 * @Date: 2019/9/28,0028
 * @Description:
 */
public class SmallestStringWithSwaps {
    int[] pre;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s.length() == 0) {
            return null;
        }
        pre = new int[s.length()];

        Map<Integer, PriorityQueue> map = new HashMap<>();
        //init
        for (int i = 0; i < s.length(); i++) {
            pre[i] = i;
        }
        //union find,合并
        pairs.forEach(pair-> union(pair.get(0), pair.get(1)));

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue());
            map.get(root).offer(chars[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(map.get(find(i)).poll());
        }
        return stringBuilder.toString();

    }

    private int find(int x) {
        if (pre[x] == x) return x;
        return pre[x] = find(pre[x]);
    }

    //find root
    private int find2(int x) {
        int r = x;//委托r查找root
        //x自己不是根节点，继续用x的上级查找根节点
        while (r != pre[r]) {
            r = pre[r];
        }

        int i = x,j;
        while (pre[i] != r) {//路径压缩
            j = pre[i];//保存上级的值
            pre[i] = r;//把x的上级改为根节点
            i = j;//继续，所有节点的上级都改为根节点
        }
        return r;
    }
    //合并
    private void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy)//如果不连通就把分支合并
            pre[fy] = fx;
    }
}
