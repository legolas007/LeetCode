package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class SelfDividingNumbers {
    public  List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (; left <= right; left++) {
            String s = String.valueOf(left);
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                int tmp = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (tmp == 0 ||left % tmp != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(left);
            }
        }
        return list;
    }
}
