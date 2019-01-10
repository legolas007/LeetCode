package string;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/1/7/0007
 * @Description:
 * 大数相乘基本思想，输入字符串，转成int数组。采用分治思想，每一位的相乘;
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";

        //声明存放结果和两个乘积的容器
        int[] result = new int[num1.length() + num2.length()];
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];

        for(int i = 0; i < num1.length();i++)
            n1[i] = num1.charAt(i)-'0';
        for(int i = 0; i < num2.length();i++)
            n2[i] = num2.charAt(i)-'0';

        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i =0 ; i < num1.length(); i++){
            for(int j =0; j < num2.length(); j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }

        //满10进位，从后往前满十进位
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i < result.length-1; i++) {
            if (result[i] ==0 && resultStr.length()==0)
                continue;
            resultStr.append(result[i]);
        }

        /*while (resultStr.length() !=0 && resultStr.charAt(0) == '0')
            resultStr.deleteCharAt(0);*/
        return resultStr.length() == 0 ? "0" : resultStr.toString();
    }
}
