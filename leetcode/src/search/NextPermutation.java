package search;

/**
 * @Author: Usher
 * @Description:
 * 1, 2, 3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 字典序算法：
 *
 * 从后往前寻找索引满足 a[k] < a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
 * 从后往前遍历，找到第一个比a[k]大的数a[l], 即a[k] < a[l].
 * 交换a[k]与a[l].
 * 反转k + 1 ~ n之间的元素。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        //从后找第一个nums[k] < nums[k+1]
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        // 如果当前值是最大值，交换成最小值
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 从后找第一个nums[k] < nums[l]
        int l = nums.length - 1;
        while (l > k && nums[l] <= nums[k]) l--;

        //交换nums[k]， nums[l]
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;

        // 反转 k+1 和 nums.length-1的数
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int lb, int ub) {
        for (int i = lb, j = ub; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
