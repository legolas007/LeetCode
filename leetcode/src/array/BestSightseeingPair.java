package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/5/31/0031
 * @Description:
 * A[i] + A[j] + i - j to (A[i] + i) + (A[j] - j)
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int max = A[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < A.length; ++i){
            res = Math.max(res, max + A[i] -i);
            max = Math.max(max, A[i] +i);
        }

        return res;
    }
}
