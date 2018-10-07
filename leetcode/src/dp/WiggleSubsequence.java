package dp;

/**
 * @Author: Usher
 * @Description:
 * Greedy算法，这里我们不在维护两个dp数组，而是维护两个变量p和q，然后遍历数组，如果当前数字比前一个数字大，则p=q+1，如果比前一个数字小，则q=p+1，最后取p和q中的较大值跟n比较，取较小的那个
 *
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int up = 1, down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1])
                up = down + 1;
            else if (nums[i] < nums[i-1])
                down = up + 1;
        }
        return Math.max(up, down);
    }
}
