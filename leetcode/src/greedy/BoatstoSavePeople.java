package greedy;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:
 */
public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length-1, result = 0;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            result++;
        }
        return result;
    }
}
