package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Usher
 * @Date: 2019/4/2/0002
 * @Description:
 */
public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {

        if (hand.length % W !=0)
            return false;

        if (W == 1)
            return true;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : hand) {
            map.merge(num, 1, Integer::sum);
        }

        int res = 0;
        boolean flag = false;
        for (int i = 0,cnt = 0; i < hand.length-1; i++) {
            if (flag) {

                i = 0;
                flag = false;
            }
            if (map.get(hand[i]) > 0 && map.get(hand[i + 1]) > 0 && hand[i + 1] != hand[i]) {
                if (hand[i + 1] - hand[i] == 1) {
                    cnt++;
                    map.put(hand[i], map.get(hand[i]) - 1);
                }
            }

            if (cnt == W-1) {
                map.put(hand[i+1], map.get(hand[i+1]) - 1);
                res++;
                cnt = 0;
                flag = true;

            }

        }
        return res == hand.length / W;
    }

}


