package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description: hash
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> list = new ArrayList<>();
        int[] t = new int[26];
        for (String b : B) {
            int[] hash = new int[26];
            for (Character c : b.toCharArray()) {
                hash[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                t[i] = Integer.max(t[i], hash[i]);
            }
        }
        for (String a : A) {
            int[] hash = new int[26];
            for (Character c : a.toCharArray()) {
                hash[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (hash[i] < t[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                list.add(a);
        }
        return list;
    }
}
