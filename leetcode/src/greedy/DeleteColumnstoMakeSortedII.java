package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/6/13/0013
 * @Description:
 */
public class DeleteColumnstoMakeSortedII {
    public int minDeletionSize(String[] A) {
        int cnt = 0, l = A[0].length();

        Set<Integer> set = new HashSet<>();

        for (int j = 1; j < A.length; j++) {
            for (int i = 0; i < l; i++) {
                if (set.contains(i) || A[j - 1].charAt(i) == A[j].charAt(i)) {
                    continue;
                }

                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    cnt++;
                    set.add(i);
                    j = 0;
                }
                break;
            }
        }
        return cnt;
    }
}
