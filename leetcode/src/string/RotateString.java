package string;

/**
 * @Author: Usher
 * @Description:
 */
public class RotateString {
    public boolean rotateString(String A, String B) {

        if(A.length() == 0&&B.length() == 0)
            return true;
        if(A.length() == 0 || B.length()==0)
            return false;
        for(int i =0;i < A.length();i++){
            String s = rotate(A,i);
            if(s.equals(B)){
                return true;
            }
        }
        return false;
    }

    private String rotate(String A, int n){
        String s1 = A.substring(0,n);
        String s2 = A.substring(n);
        return s2 + s1;
    }
}
