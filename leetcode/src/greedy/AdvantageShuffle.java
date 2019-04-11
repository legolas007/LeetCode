package greedy;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/4/2/0002
 * @Description:
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] ans = new int[A.length];
        for (int i = 0;i < B.length;i++) {
            Integer key = map.higherKey(B[i]);
            if (key == null) ans[i] = -1;
            else {
                ans[i] = key;
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) map.remove(key);
            }
        }
        for (int i = 0;i < ans.length;i++) {
            if (ans[i] == -1) {
                int firstKey = map.firstKey();
                ans[i] = firstKey;
                map.put(firstKey, map.get(firstKey) - 1);
                if (map.get(firstKey) == 0) map.remove(firstKey);
            }
        }
        return ans;
    }

    public int[] advantageCount2(int[] A, int[] B) {
        Arrays.sort(A);
        int n=A.length;
        int[] res= new int[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);
        for (int i=0; i<n; i++) pq.add(new int[]{B[i], i});
        int lo=0, hi=n-1;
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            int idx=cur[1], val=cur[0];
            if (A[hi]>val) res[idx]=A[hi--];
            else res[idx]=A[lo++];
        }
        return res;
    }
}
