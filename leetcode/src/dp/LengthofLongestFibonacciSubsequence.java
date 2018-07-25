package dp;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 *
 *
 */
public class LengthofLongestFibonacciSubsequence {
   public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        int ans = 0;
        for(int i =0;i < A.length;i++){
            for(int j = i+1;j < A.length;j++){
                int x = A[i];
                int y = A[j];
                int z = x + y;

                int count = 2;
                while (set.contains(z)) {
                    x = y;
                    y = z;
                    z = x + y;
                    ans = Math.max(ans, ++count);
                }
            }
        }

        return ans;
    }

/*    public int lenLongestFibSubseq(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        int [][] dp = new int[A.length][A.length];
        for(int i=0; i<A.length;++i){
            map.put(A[i],i);
            for(int j=i; j<A.length;++j){
                dp[i][j]=2;
            }
        }
        int max = 0;
        for(int i=1; i<A.length;++i){
            for(int j=i+1;j<A.length;++j){

                int Ax = A[j]-A[i];
                int index = 0;
                if(!map.containsKey(Ax)){
                    continue;
                }

                index = map.get(Ax);
                dp[i][j]=Math.max(dp[i][j],dp[index][i]+1);
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }*/
}
