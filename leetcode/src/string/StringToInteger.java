package string;

import java.util.Iterator;

/**
 * @Author: Usher
 * @Description:
 * 1.正负号；2.中间存在字母（只取字母前的数字）;3.溢出;4.前后空格
 *
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.trim().length() < 1){
            return 0;
        }
        //前后空格
        char[] chars = str.trim().toCharArray();
        int index = 0;
        String minStr = "";
        //判断正负号
        if (chars[0] == '-'){
            minStr = "-";
            index++;
        }else if (chars[0] == '+')
            index++;
        String res = "";
        for (int i = index;i < chars.length;i++){
            if (chars[i] - '0' >= 0 && chars[i] - '9' <= 0){
               res += chars[i];
            }else break;
        }
        if(res == "")
            return 0;
        if (Long.valueOf(minStr + res) >Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (Long.valueOf(minStr + res)<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return Integer.valueOf(minStr + res) ;
    }
}
