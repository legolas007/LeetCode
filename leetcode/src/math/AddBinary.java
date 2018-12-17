package math;

import java.math.BigInteger;

/**
 * @Author: Usher
 * @Description:
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        return new BigInteger(a,2).add(new BigInteger(b,2)).toString(2);
    }

    public String addBinary2(String a, String b) {
        char[] ch1 = a.toCharArray(), ch2 = b.toCharArray();
        char[] res = new char[Math.max(ch1.length, ch2.length)+1];
        int i = ch1.length-1, j = ch2.length-1, k = res.length-1;
        while (i >= 0 || j >= 0) {
            int sum = (i < 0 ? 0 : ch1[i]-'0') + (j < 0 ? 0 : ch2[j]-'0') + res[k];
            res[k] = (char)(sum % 2);
            res[k-1] += sum / 2;
            i--;
            j--;
            k--;
        }
        for (i = 0; i < res.length; i++)
            res[i] = (char)(res[i] + '0');
        return res[0] == '0' ? new String(res, 1, res.length-1) : new String(res);
    }
}
