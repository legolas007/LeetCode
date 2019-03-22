package graph;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/3/10/0010
 * @Description:
 */
public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int res = -1;
        int count = 0;
        if (N == 1) {
            return N;
        }
        for (int[] ints : trust) {
            int value = ints[1];
            boolean flag = true;

            for (int[] ints1 : trust) {
                if (ints1[0] == value) {
                    flag = false;
                    count = 0;
                    break;
                }
                if (ints1[1] == value) {
                    count++;
                }
            }
            if (flag && count == N - 1) {
                res = value;
                break;
            }
        }

        return res;
    }

    public int findJudge296(int N, int[][] arr) {
        int[] trust = new int[N];
        int[] trusted = new int[N];
        for (int[] ints : arr) {
            int a = ints[0];
            int b = ints[1];
            trust[a - 1]++;
            trusted[b - 1]++;
        }
        for(int i = 0; i < N; i++){
            if(trust[i] == 0 && trusted[i] == N - 1)
                return i + 1;
        }
        return -1;
    }
}
