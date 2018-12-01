package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class DIStringMatch {
    public int[] diStringMatch2(String S) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[S.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            list.add(i);
        }

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == 'I') {
                list.sort(Comparator.comparingInt(o -> o));
                arr[i] = list.get(0);
                list.remove(0);
            } else {
                list.sort((o1, o2) -> o2 - o1);
                arr[i] = list.get(0);
                list.remove(0);
            }
        }
        arr[S.length()] = list.get(0);
        return arr;
    }

    public static int[] diStringMatch(String S) {
        int[] ans = new int[S.length() + 1];
        int increase = 0, decrease = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = increase++;
            } else {
                ans[i] = decrease--;
            }
        }
        ans[S.length()] = increase;
        return ans;
    }
}
