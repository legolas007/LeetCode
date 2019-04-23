package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/4/16/0016
 * @Description:
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if (n ==0)
            return 0;
        int[] vally = new int[n], peek = new int[n];
        vally[0] = peek[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < A.length; i++) {
            vally[i] = A[i] < A[i - 1] ? peek[i - 1] + 1 : 1;
            peek[i] = A[i] > A[i - 1] ? vally[i - 1] + 1 : 1;
            maxLen = Math.max(maxLen, Math.max(vally[i], peek[i]));
        }
        return maxLen;
    }

    public int maxTurbulenceSize2(int[] A) {

        if(A.length==1) return 1;

        Set<Integer> set = new HashSet<>();
        for(int a:A) set.add(a);

        if(A.length==2) return set.size()==1?1:2;

        int max = 2;
        int count = 2;

        for(int i=2;i<A.length;i++){

            // System.out.println(i+ " "+ (A[i]-A[i-1])*(A[i-1]-A[i-2]));
            if((A[i]>A[i-1]) && (A[i-1]<A[i-2]) || (A[i]<A[i-1]) && (A[i-1]>A[i-2])){
                count++;
                // System.out.println(i+" "+count);
                max = Math.max(max,count);
            }else{
                count = 2;
            }

        }

        if(max==2) return set.size()==1?1:2;
        return max;
    }}
