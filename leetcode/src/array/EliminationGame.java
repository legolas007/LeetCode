package array;

/**
 * @Author: Usher
 * @Description:
 * 第一次从左往右删除的时候，奇数都被删掉了，剩下的都是偶数。如果我们对所有数都除以2，那么得到一个1到n/2的新数列。下一次我们从右往左删出，那么返回的结果应该是调用递归的结果lastRemaining(n / 2)在数组1到n/2之间的镜像。何为镜像，比如1, 2, 3, 4这个数字，2的镜像就是3, 1的镜像是4
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));

    }
}
