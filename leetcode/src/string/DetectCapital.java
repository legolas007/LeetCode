package string;

/**
 * @Author: Usher
 * @Description:
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        boolean isFirstCap = word.charAt(0) < 97 ;
        boolean isSecondCap = word.charAt(1) < 97;

        if (!isFirstCap && isSecondCap) {
            return false;
        }

        for (int i = 2; i<word.length() ; i++) {
            boolean isCap = word.charAt(i) < 97;
            if ((isSecondCap && !isCap) || (!isSecondCap && isCap)) {
                return false;
            }
        }
        return true;
    }
}
