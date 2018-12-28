package greedy;

/**
 * @Author: Usher
 * @Description:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        /*Stack<Character> stack = new Stack<>();
        int len = num.length() - k;

        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            //pop k
            while (!stack.isEmpty() && stack.peek() > cur && stack.size() + k > i) {
                stack.pop();
            }
            stack.push(cur);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        for (char c : stack) {
            if (index == 0 && c == '0') {
                continue;
            }
            index++;

            if (index <= len) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();*/

        int len = num.length();
        if(k == num.length())
            return "0";
        while (k != 0) {

            for (int j = 0; j < len; j++) {
                for (int i = 0; i < num.length() - 1; i++) {
                    if (num.charAt(i) > num.charAt(i + 1)) {//最小值
                    //if (num.charAt(i) < num.charAt(i + 1)) {最大值
                        num = num.substring(0, i) + num.substring(i + 1);
                        k--;
                        if (k == 0 && num.length() > 1) {
                            int count = 0;
                            for (int l = 0; l < num.length(); l++) {
                                if (num.charAt(l) == '0') {
                                    ++count;
                                } else break;
                            }
                            if(count == num.length() - k)
                                return "0";
                            else return num.substring(count);
                        }else if(k == 0)
                            return num;
                        break;
                    }
                }
            }
            num = num.substring(0, num.length() - k);
            k = 0;
        }
        if (num.length() == 0)
            return "0";
        return num;
    }

}
