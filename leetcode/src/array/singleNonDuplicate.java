package array;

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

 Example 1:
 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2
 */
public class singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int l = 0,h = nums.length - 1;
        while (l < h){
            int m = l + (h-1) / 2;
            if(m % 2 == 1) m--;
            if(nums[m]  == nums[m+1])
                l = m+2;
            else h = m;
        }
        return nums[l];
    }
}
