package array;


/**
 * @Author: Usher
 * @Date: 2018/12/24/0024
 * @Description:
 * 仔细观察我们可以得出，最后的数是该数字范围内所有的数的左边共同的部分，如果上面那个例子不太明显，我们再来看一个范围[26, 30]，它们的二进制如下：
 *
 * 11010　　11011　　11100　　11101　　11110
 *
 * 直接平移m和n，每次向右移一位，直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果
 */
public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

}
