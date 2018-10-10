package greedy;

/**
 * @Author: Usher
 * @Description:
 * 联合查找Union Find的解法。该解法对于处理群组问题时非常有效，比如岛屿数量有关的题就经常使用UF解法。核心思想是用一个root数组，每个点开始初始化为不同的值，如果两个点属于相同的组，就将其中一个点的root值赋值为另一个点的位置，这样只要是相同组里的两点，通过find函数会得到相同的值。 那么如果总共有n个数字，则共有 n/2 对儿，所以我们初始化 n/2 个群组，我们还是每次处理两个数字。每个数字除以2就是其群组号，那么属于同一组的两个数的群组号是相同的，比如2和3，其分别除以2均得到1，所以其组号均为1。那么这对解题有啥作用呢？作用忒大了，由于我们每次取的是两个数，且计算其群组号，并调用find函数，那么如果这两个数的群组号相同，那么find函数必然会返回同样的值，我们不用做什么额外动作，因为本身就是一对儿。如果两个数不是一对儿，那么其群组号必然不同，在二者没有归为一组之前，调用find函数返回的值就不同，此时我们将二者归为一组，并且cnt自减1，忘说了，cnt初始化为总群组数，即 n/2。那么最终cnt减少的个数就是交换的步数，还是用上面讲解中的例子来说明吧：
 *
 * [3   1   4   0   2   5]
 *
 * 最开始的群组关系是：
 *
 * 群组0：0，1
 *
 * 群组1：2，3
 *
 * 群组2：4，5
 *
 * 取出前两个数字3和1，其群组号分别为1和0，带入find函数返回不同值，则此时将群组0和群组1链接起来，变成一个群组，则此时只有两个群组了，cnt自减1，变为了2。
 *
 * 群组0 & 1：0，1，2，3
 *
 * 群组2：4，5
 *
 * 此时取出4和0，其群组号分别为2和0，带入find函数返回不同值，则此时将群组0&1和群组2链接起来，变成一个超大群组，cnt自减1，变为了1。
 *
 * 群组0 & 1 & 2：0，1，2，3，4，5
 *
 * 此时取出最后两个数2和5，其群组号分别为1和2，因为此时都是一个大组内的了，带入find函数返回相同的值，不做任何处理。最终交换的步数就是cnt减少值，为2
 */
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int res = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i + 1] == (row[i] ^ 1)) {
                continue;
            }
            res++;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == (row[i] ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = row[i] ^ 1;
                    break;
                }
            }
        }
        return res;
    }
    public int minSwapsCouples2(int[] row) {
        int res = 0, cnt = row.length;

        int[] root = new int[row.length];

        for (int i = 0; i < row.length; i++) {
            root[i] = 1;
        }
        for (int i = 0; i < row.length; i++) {
            int x = find(root, row[i] / 2);
            int y = find(root, row[i + 1] / 2);
            if (x != y) {
                root[x] = y;
                --cnt;
            }
        }
        return row.length / 2 - cnt;
    }

    int find(int[] root, int i) {
        return (i == root[i]) ? i : find(root, root[i]);
    }

}
