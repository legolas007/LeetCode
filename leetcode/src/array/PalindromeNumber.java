package array;

/**
 * @Author: Usher
 * @Description:
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
