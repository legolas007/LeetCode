package array;

/**
 * @Author: Usher
 * @Description:
 * 树状数组
 * 根据给定输入数组建立一个树状数组bit，然后更新某一位数字时，根据最低位的值来更新后面含有这一位数字的地方，一般只需要更新部分偶数位置的值即可，在计算某一位置的前缀和时，利用树状数组的性质也能高效的算出来
 *
 */
public class NumArray {
    int[] num;
    int[] bit;
    public NumArray(int[] nums) {
        num = new int[nums.length];
        bit = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }

    }

    public void update(int i, int val) {
        int diff = val - num[i + 1];
        for (int j = i + 1; j < num.length; j += (j & -j)) {
            bit[j] += diff;
        }
        num[i + 1] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    int getSum(int i) {
        int res = 0;
        for (int j = i; j > 0; j -= (j&-j)) {
            res += bit[j];
        }
        return res;
    }
}
