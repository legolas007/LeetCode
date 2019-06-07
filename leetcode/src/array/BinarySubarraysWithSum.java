package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/6/4/0004
 * @Description:
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j <= A.length; j++) {

                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += A[k];
                }

                if (sum == S) {
                    res++;
                }

            }
        }
        return res;
    }

    public int numSubarraysWithSum2(int[] A, int S) {
        int n = A.length;
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : sum) {
            res += map.getOrDefault(num, 0);
            map.put(num + S, map.getOrDefault(num + S, 0) + 1);
        }
        return res;
    }

    public int numSubarraysWithSum3(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == S) count++;

            if (!map.containsKey(sum)) map.put(sum, 1);
            else map.put(sum, map.get(sum) + 1);

            if (map.containsKey(sum - S)) {
                count += map.get(sum - S);
                if (S == 0) count--; //这个判断是关键！！ 只要S == 0，那么就会多算一遍
            }


        }
        return count;
    }
}
