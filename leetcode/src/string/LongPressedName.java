package string;

/**
 * @Author: Usher
 * @Date: 2019/1/30/0030
 * @Description:
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int j = 0;
        for (int i = 0; i < typed.length(); i++) {
            if (n == 0)
                break;
            if (typed.charAt(i) == name.charAt(j)) {
                j++;
                n--;
            }
        }

        return n == 0;
    }
}
