package array;

import java.util.Arrays;
import java.util.Vector;

/**
 * Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.

Example
Given an array [0,4,4,0,0,2,4,4], value=4

return 4 and front four elements of the array is [0,0,0,2]

 * @author usher
 *
 */
public class RmEle {

	public int removeElement(int[] nums, int val) {
		int pos = 0;
		for(int i = 0; i < nums.length ; i++) {
			if (val != nums[i]) {
				nums[pos] = nums[i];
				pos++;
			}
		}
		return pos;
	}
}
