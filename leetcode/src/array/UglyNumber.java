package array;

/**
 * @Author: Usher
 * @Description:
 * 如果仅包含2,3,5，就继续除以它，最后如果num不等于1，说明还包括其他因子
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        while( num % 2 == 0) num /=2;
        while( num % 3 == 0) num /=3;
        while( num % 5 == 0) num /=5;
        return num == 1;
    }
}
