package search;

/**
 * @Author: Usher
 * @Description:
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0,end = n;
        while(start+1 < end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        return start+1;
    }
}