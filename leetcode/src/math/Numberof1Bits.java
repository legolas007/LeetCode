package math;

/**
 * @Author: Usher
 * @Description:
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        long longNum = Integer.toUnsignedLong(n);
        int count = 0;
        while (longNum!=0){
            longNum &= (longNum - 1);
            count++;
        }
        return count;
    }
}
