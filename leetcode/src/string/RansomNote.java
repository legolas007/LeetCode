package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--map[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
