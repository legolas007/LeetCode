package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/9/8,0008
 * @Description:
 */
public class ShortestDistancetoTargetColor {
    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> res = new ArrayList<>();

        for (int[] query : queries) {
            int leftStep = 0, rightStep = 0;
            boolean leftFlag = false, rightFlag = false;
            for (int i=query[0]; i >=0; i--) {
                if (colors[i] == query[1]) {
                    leftFlag = true;
                    break;
                }
                leftStep++;
            }

            if (!leftFlag) {
                leftStep = Integer.MAX_VALUE;
            }
            for (int i = query[0]; i < colors.length; i++) {
                if (colors[i] == query[1]) {
                    rightFlag = true;
                    break;
                }
                rightStep++;
            }
            if (!rightFlag) {
                rightStep = Integer.MAX_VALUE;
            }

            int min = Math.min(rightStep, leftStep);
            if (min == Integer.MAX_VALUE) {
                res.add(-1);
            }else res.add(min);

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestDistanceColor(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 2, 3, 2, 1, 2, 3, 3, 2, 1, 2}, new int[][]{{1, 2}, {10, 3}, {6, 1}, {1, 1},}).toArray()));
    }
}
