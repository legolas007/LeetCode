package string;

/**
 * @Author: Usher
 * @Date: 2019/6/13/0013
 * @Description:
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        if (s.length() == 0)
            return 0;
        String[] strings = s.split(" ");
        int res = 0;
        for (String string : strings) {
            string.trim();
            if (!string.equals("")) {
                res++;
            }
        }
        return res;
    }
}
