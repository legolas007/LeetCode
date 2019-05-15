package math;

/**
 * @Author: Usher
 * @Date: 2019/4/27/0027
 * @Description:
 */
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);

        for (int i = 0; i < s.length()-1; i++) {
            String sub = s.substring(i, i + 2);
            if (sub.charAt(0) == sub.charAt(1)) {
                return false;
            }
        }
        return true;
    }
}
