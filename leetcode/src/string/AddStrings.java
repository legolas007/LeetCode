package string;

import java.math.BigDecimal;

/**
 * @Author: Usher
 * @Description:
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int rem = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 >= 0 || p2 >= 0){
            int sum = 0;
            if(p1 >= 0){
                sum += num1.charAt(p1--) - '0';
            }
            if(p2 >= 0){
                sum += num2.charAt(p2--) - '0';
            }
            sum += carry;
            rem = sum % 10;
            carry = sum / 10;
            sb.append(rem);
        }

        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
