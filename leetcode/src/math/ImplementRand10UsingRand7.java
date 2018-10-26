package math;

/**
 * @Author: Usher
 * @Description:
 */
public class ImplementRand10UsingRand7 {
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = (int) (7 * (Math.random() * 7 - 1) + (Math.random() * 7 - 1));
        }
        return result % 10 + 1;
    }
}
