package others;

import java.math.BigInteger;

/**
 * @Author: Usher
 * @Description:
 */
public class NumberComplement {
    public int findComplement(int num) {
        char[] chars = Integer.toBinaryString(num).toCharArray();

        for (int i =0;i < chars.length;i++) {

            if (chars[i] == '1')
                chars[i] = '0';
            else chars[i] = '1';
        }
        return Integer.parseInt(new BigInteger(String.valueOf(chars), 2).toString());
    }
}
