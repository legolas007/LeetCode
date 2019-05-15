package string;

/**
 * @Author: Usher
 * @Date: 2019/4/27/0027
 * @Description:
 */
public class ValidPalindromeII {

    public boolean validPalindrome2(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return isPal(s.substring(i+1,j+1)) || isPal(s.substring(i,j));
            }
            i++;j--;
        }
        return true;
    }

    private boolean isPal(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (!isPalindrome(s)) {
            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(0, i) + s.substring(i);
                if (isPalindrome(tmp)) {
                    return true;
                }
            }
        } else return true;

        return false;
    }

    public boolean isPalindrome(String s) {
        int[] map = new int[256];
        for (int i = 0; i < 10; i++)
            map[i + '0'] = 1 + i;
        for (int i = 0; i < 26; i++) {
            map[i + 'a'] = 11 + i;
            map[i + 'A'] = 11 + i;
        }

        char[] chars = s.toCharArray();

        int l = 0, r = s.length() - 1;
        while (l < r) {
            int cl = map[chars[l]];
            int cr = map[chars[r]];

            if (cl != 0 && cr != 0) {
                if (cl != cr)
                    return false;
                l++;
                r--;
            } else {
                if (cl == 0)
                    l++;
                if (cr == 0)
                    r--;
            }
        }

        return true;
    }
}
