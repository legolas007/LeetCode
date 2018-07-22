package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 *
 * Input: A = [2, 4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 */
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int m = 0; m < A.length; m++) {
            long count = 1;
            int num = A[m];
            for(Integer i : map.keySet()){
                if(num % i == 0 && map.containsKey(num/i)) {
                    count +=map.get(i) * map.get(num/i);
                }
            }
            map.put(num, count);
            res = (res + count)%mod;
        }
        return (int)res;
    }
}
