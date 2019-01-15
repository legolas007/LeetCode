package array;

/**
 * @Author: Usher
 * @Date: 2019/1/14/0014
 * @Description:
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];

            if (product < k) {
                count++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                product = product * nums[j];
                if (product >= k)
                    break;
                count++;
            }
        }
        return count;
    }

    /**
     * 滑动窗口
     *
     * 维护一个数字乘积刚好小于k的滑动窗口，
     * 用变量left来记录其左边界的位置，右边界i就是当前遍历到的位置。遍历原数组，
     * 用prod乘上当前遍历到的数字，然后进行while循环，如果prod大于等于k，
     * 则滑动窗口的左边界需要向右移动一位，删除最左边的数字，那么少了一个数字，
     * 乘积就会改变，所以用prod除以最左边的数字，然后左边右移一位，即left自增1。
     * 当我们确定了窗口的大小后，就可以统计子数组的个数了，就是窗口的大小。为啥呢，
     * 比如[5 2 6]这个窗口，k还是100，右边界刚滑到6这个位置，
     * 这个窗口的大小就是包含6的子数组乘积小于k的个数，即[6], [2 6], [5 2 6]，
     * 正好是3个。所以窗口每次向右增加一个数字，然后左边去掉需要去掉的数字后，
     * 窗口的大小就是新的子数组的个数，每次加到结果res中即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int res = 0, prod = 1, left = 0;

        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];

            while (prod >= k)
                prod /= nums[left++];

            res += i - left + 1;
        }
        return res;
    }

}
