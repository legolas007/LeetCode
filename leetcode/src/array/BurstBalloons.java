package array;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {
    public int findMinArrowShots(int[][] points){
        if (points == null || points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrowPos = points[0][1];
        int arrowCnt = 1;

        for (int i = 1;i<points.length;i++){
            if(arrowPos >= points[i][0]){
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
