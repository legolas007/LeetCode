package array;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/4/11/0011
 * @Description:
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();

        BigInteger num = new BigInteger("0");
        BigInteger multi = new BigInteger("2");
        BigInteger mod = new BigInteger("5");
        for (int i = 0, len = A.length; i < len; i++) {
            num = num.multiply(multi);
            num =num.add(BigInteger.valueOf(A[i]));

            BigInteger[] arr=num.divideAndRemainder(mod);
            if (arr[1].intValue() == 0) {
                res.add(true);
            } else res.add(false);

        }
        return res;
    }
    public List<Boolean> prefixesDivBy52(int[] A) {
        List<Boolean> res = new ArrayList<>();

        int num = 0;

        for (int i = 0, len = A.length; i < len; i++) {
            num <<= 1;
            num += A[i];
            num %= 5;
            res.add(num == 0);
        }
        return res;
    }

}
