package main.java.com.usher.algorithms.array;

/**
 * 二分
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 x is guaranteed to be a non-negative integer.


 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 */
public class Sqrt {
    public int sqrt(int x){
        if (x <= 1) return x;
        int l = 1, h = x;
        if(l <= h){
            int mid = l + (h-l)/2;
            int sqrt = x/mid;
            if(sqrt == mid) return mid;
            else if (sqrt < mid) h = mid-1;
            else l = mid + 1;
        }
        return h;
    }

}
