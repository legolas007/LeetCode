package string;

/**
 * @Author: Usher
 * @Date: 2019/2/13/0013
 * @Description:
 */
public class ReverseBits {
    public int reverseBits(int n) {
        Long lo = Integer.toUnsignedLong(n);
        StringBuilder sb = new StringBuilder(Long.toString(lo, 2));
        while (sb.length() != 32) {
            sb.insert(0, "0");
        }
        sb.reverse();
        return (int) Long.parseLong(sb.toString(), 2);
    }
}
