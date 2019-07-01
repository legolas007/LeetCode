package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/6/15/0015
 * @Description:
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int numHouses = houses.length;
        int numHeaters = heaters.length;
        if(numHouses==0){
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxMinDist = Integer.MIN_VALUE;
        int i=0, j=0;
        int prevHeaterLocation = -1000000000;

        while(i<numHouses && j<numHeaters){
            if(houses[i]>heaters[j]){
                prevHeaterLocation = heaters[j];
                j++;
            } else {
                int minDist = Math.min(houses[i]-prevHeaterLocation, heaters[j]-houses[i]);
                maxMinDist = Math.max(minDist, maxMinDist);
                i++;
            }

        }
        while(i<numHouses){
            maxMinDist = Math.max(maxMinDist, houses[i]-prevHeaterLocation);
            i++;
        }
        return maxMinDist;
    }
}
