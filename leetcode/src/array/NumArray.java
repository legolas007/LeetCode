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
    public NumArray(int[] nums) {
        num = nums;

    }

    public void update(int i, int val) {
        num[i] = val;
    }

    public int sumRange(int i, int j){
        int sum = 0;

        for (int k = i; k <= j; k++) {
            sum += num[k];
        }
        return sum;
    }

}
