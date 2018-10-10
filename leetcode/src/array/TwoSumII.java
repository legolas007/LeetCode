package array;

/**
 * @Author: Usher
 * @Description:
 * Input array is sorted
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        int sum=0;

        while(start<=end){
            sum=numbers[start]+numbers[end];
            if(target==sum){
                return new int[]{start+1,end+1};
            }
            else if(sum<target){
                start++;
            }else{
                end--;
            }
        }
        return null;
    }
}
