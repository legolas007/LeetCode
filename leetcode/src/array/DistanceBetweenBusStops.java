package array;

/**
 * @Author: Usher
 * @Date: 2019/9/8,0008
 * @Description:
 */
public class DistanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] sum = new int[distance.length + 1];
        sum[0] = 0;

        for (int i = 1; i <= distance.length; i++) {
            sum[i] = sum[i - 1] + distance[i - 1];
        }

        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        return Math.min(sum[destination] - sum[start], sum[distance.length] - (sum[destination] - sum[start]));
    }
}
