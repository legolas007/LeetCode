package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class NumArray {

    /*
    //time:739ms
    private int[] arr;
    public NumArray(int[] nums) {
        this.arr = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i;k <= j;k++){
            sum += arr[k];
        }
        return sum;
    }*/

    //dp time:201ms
    int[] sum;

    public NumArray(int[] nums) {

        this.sum = new int[nums.length];

        if (nums.length != 0)
            sum[0] = nums[0];

        for (int i =1;i < nums.length;i++)
            sum[i] = nums[i] + sum[i-1];
    }

    public int sumRange(int i, int j){
        if (i == 0)
            return sum[j];
        return sum[j] - sum[i-1];
    }
}
