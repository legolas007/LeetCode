package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/7/27,0027
 * @Description:
 */
public class NumberofEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length, cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1] ||
                        dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int n = dominoes.length, cnt = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            String s = dominoes[i][0] + "" + dominoes[i][1];
            if (!map.containsKey(s)) {

                String reverse = dominoes[i][1] + "" + dominoes[i][0];
                if (!map.containsKey(reverse) ){
                    map.put(s,1);
                } else {
                    map.put(reverse, map.getOrDefault(reverse, 0) + 1);
                }
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        for (int num : map.values()) {
            cnt += (num * (num - 1)) >> 1;
            System.out.println(num);
        }
        return cnt;
    }


}
