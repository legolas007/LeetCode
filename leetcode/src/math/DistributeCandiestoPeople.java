package math;

/**
 * @Author: Usher
 * @Date: 2019/07/07,0007
 * @Description:
 */
public class DistributeCandiestoPeople {
    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];

        int idx = 0,cnt = 1;
        while (candies > 0) {
            if (idx < num_people) {
                if (candies >= cnt) {
                    candies -= cnt;
                    res[idx] = res[idx] + cnt;
                    idx++;
                    cnt++;
                } else {
                    res[idx] = res[idx] + candies;
                    break;
                }
            }else {
                idx = 0;
            }
        }
        return res;
    }

    public int[] distributeCandies2(int candies, int num_people) {
        int[] ans = new int[num_people];
        for (int i = 0; candies > 0; ) {
            ans[i % num_people] += Math.min(candies, i++);
            candies -= i;
        }
        return ans;
    }
}
