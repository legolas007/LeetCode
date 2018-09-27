package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Usher
 * @Description:
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (o1, o2) -> {
            String x = o1 + o2;
            String y = o2 + o1;
            return y.compareTo(x);
        };

        Arrays.sort(strings, comparator);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        String s = stringBuilder.toString();
        if (s.charAt(0) == '0') {
            return "0";
        }
        return s;
    }
}
