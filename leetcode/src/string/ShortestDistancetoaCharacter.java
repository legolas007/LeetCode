package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/5/16/0016
 * @Description:
 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        Arrays.fill(res, n);

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                res[i] = 0;
                continue;
            }

            int j = i + 1;
            while (j < n && S.charAt(j) != C) {
                j++;
            }

            if (j < n) {
                res[i] = j - i;
            }

            j = i - 1;
            while (j >= 0 && S.charAt(j) != C) {
                j--;
            }

            if (j >= 0) {
                res[i] = Math.min(res[i], i - j);
            }
        }
        return res;
    }

    public int[] shortestToChar2(String S, char C) {
        List<Integer> indeciesOfC = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == C){
                indeciesOfC.add(i);
            }
        }


        int[] result = new int[S.length()];
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == C){
                result[i] = 0;
            } else {
                result[i] = shortestDistiance(i,indeciesOfC);
            }
        }

        return result;



    }

    private int shortestDistiance(int index, List<Integer> indcies){
        int shortestDistnace = Integer.MAX_VALUE;
        for(Integer x : indcies ){
            int diff = Math.abs(index - x);
            shortestDistnace = Math.min(shortestDistnace, diff);
        }
        return shortestDistnace;

    }
}
