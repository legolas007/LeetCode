package math;


/**
 * @Author: Usher
 * @Date: 2019/5/18/0018
 * @Description:
 */
public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String s = Integer.toBinaryString(i);
            if (!S.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
