package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/3/28/0028
 * @Description:
 */
public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {

        int res = 0;

        /*for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    res++;
                }
            }

        }*/

        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x : P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v : count)
            ans += v * (v - 1) / 2;
        return ans;
    }

    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = A.length;
        int sum = 0, ans = 0;
        for(int i = 0; i < n; i++){
            sum += A[i];
            int res = sum % K;
            if(res < 0 ) res += K;
            if(map.containsKey(res)){
                int num = map.get(res);
                ans += num;
                map.put(res, num+1);
            }
            else{
                map.put(res, 1);
            }
        }
        return ans;
    }

    public int subarraysDivByK3(int[] A, int K) {
        int[] count = new int[K];
        count[0] = 1;
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            res += count[prefix]++;
        }
        return res;
    }
}
