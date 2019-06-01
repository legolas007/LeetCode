package array;

/**
 * @Author: Usher
 * @Date: 2019/5/29/0029
 * @Description:
 */
public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, res = 0;
        int[] sixtySeconds = new int[60];

        for (int i = 0; i < n; i++) {
            sixtySeconds[time[i] % 60]++;
        }

        for (int i = 1; i <30; i++) {
            res += (sixtySeconds[i] * sixtySeconds[60 - i]);
        }

        if (sixtySeconds[0] >= 2) {
            res += sixtySeconds[0] * (sixtySeconds[0] - 1) / 2;
        }
        if (sixtySeconds[30] >= 2) {
            res += sixtySeconds[30] * (sixtySeconds[30] - 1) / 2;
        }
        return res;
    }
}
