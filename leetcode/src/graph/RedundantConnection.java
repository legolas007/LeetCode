package graph;

/**
 * @Author: Usher
 * @Description:
 * 并查集Union-Find
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 */
public class RedundantConnection {
    int[] pre;
    public int[] findRedundantConnection(int[][] edges) {
         pre = new int[2001];
         //init
        for (int i = 1; i < pre.length; i++) {
            pre[i] = i;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }else {
                mix(edge[0],edge[1]);
            }
        }
        return new int[2];
    }

    //合并
    private void mix(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy)//如果不连通就把分支合并
            pre[fy] = fx;
    }

    //find root
    private int find(int x) {
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
}
