package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/2/6/0006
 * @Description:
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {

        if (nums.length == 0)
            return false;

        int[] f = new int[nums.length];

        f[0] = 1;
        for (int i =1;i < nums.length;i++){
            f[i] = 1;
            for (int j =0;j < i;j++){
                if (nums[i] > nums[j])
                    f[i] = Math.max(f[i],f[j]+1);
            }
        }

        Arrays.sort(f);

        return f[nums.length - 1] >= 3;
    }
}
