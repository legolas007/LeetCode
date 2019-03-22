package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/3/9/0009
 * @Description:
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {

        List<String> list = new ArrayList<>();
        int[] dict = new int[256];
        for (int i = 0; i < A[0].length(); i++) {
            dict[A[0].charAt(i)]++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] cur = new int[256];

            for (int j = 0; j < A[i].length(); j++) {
                cur[A[i].charAt(j) ]++;
            }

            for (int j = 0; j < 256; j++) {
                if (dict[j] > cur[j]) {
                    dict[j] = cur[j];
                }
            }
        }

        for (int i = 0; i < 256; i++)
            for (int j = 0; j < dict[i]; j++) {
                list.add(String.valueOf(Character.toChars(i)));
            }
        return list;

    }
}
