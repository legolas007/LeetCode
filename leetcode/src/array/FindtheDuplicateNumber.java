package array;

/**
 * @Author: Usher
 * @Description:
 * 我们在区别[1, n]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，如果个数大于mid，则说明重复值在[mid+1, n]之间，反之，重复值应在[1, mid-1]之间，然后依次类推，直到搜索完成，此时的low就是我们要求的重复值
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    /**
     * 快慢指针，如果有重复值，必定形成环
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0, t = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        do {
            slow = nums[slow];
            t = nums[t];
        } while (slow != t);
        return slow;
    }
}
