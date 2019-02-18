package array;

/**
 * @Author: Usher
 * @Date: 2019/2/13/0013
 * @Description:
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;

        return Integer.bitCount(res);
    }
}
