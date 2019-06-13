package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/6/11/0011
 * @Description:
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int mod3 = i % 3;
            int mod5= i % 5;

            if (mod3== 0 && mod5== 0) {
                list.add("FizzBuzz");
            } else if (mod3 == 0) {
                list.add("Fizz");
            } else if (mod5 == 0) {
                list.add("Buzz");
            }

            list.add(String.valueOf(i));
        }
        return list;
    }
}
