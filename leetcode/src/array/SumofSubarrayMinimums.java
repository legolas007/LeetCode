package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/07/07,0007
 * @Description:
 */
public class SumofSubarrayMinimums {

    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        if (A.length == 0) {
            return 0;
        }

        int mod = 1000000000 + 7;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];
        }

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0,k = 0; j < n; j++) {
                k++;
                min = Math.min(min, A[j]);
                if (k == i) {
                    sum += min;
                    min = Integer.MAX_VALUE;
                    j -= i-1;
                    k = 0;
                }

            }

            sum %= mod;
        }

        return sum % mod;
    }

    public int sumSubarrayMins2(int[] A) {
        int ans = 0 ;
        int MOD = (int) Math.pow(10,9) + 7;

        int[] left = new int[A.length];
        int[] right = new int[A.length];

        for(int i = 0 ; i < A.length; i++) left[i] = i+1;
        for(int i = 0 ; i < A.length; i++) right[i] = A.length - i;

        Stack<Integer> ple = new Stack<>();
        Stack<Integer> nle = new Stack<>();

        for(int i = 0 ; i < A.length ; i++){
            while(!ple.isEmpty() && A[ple.peek()] > A[i]){
                ple.pop();
            }
            left[i] = ple.isEmpty() ? i +1 : i - ple.peek();

            while(!nle.isEmpty() && A[nle.peek()] > A[i]){
                int cur = nle.pop();
                right[cur] = i - cur;
            }
            nle.push(i);
            ple.push(i);
        }

        for(int i = 0 ; i < A.length ; i++){
            ans = ans % MOD + ( A[i] *  left[i] * right[i] ) % MOD;
        }

        return ans;
    }
}
