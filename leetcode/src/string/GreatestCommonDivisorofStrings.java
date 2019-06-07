package string;

/**
 * @Author: Usher
 * @Date: 2019/6/5/0005
 * @Description:
 */
public class GreatestCommonDivisorofStrings {
    public String gcdOfStrings(String str1, String str2) {


        String greatestStr = "";
        for (int i = str1.length(); i > 0; i--) {
            String subStr = str1.substring(0, i);
            if (str2.startsWith(subStr)) {
                StringBuilder stringBuilder = new StringBuilder(subStr);
                while (stringBuilder.length() < str2.length()) {
                    stringBuilder.append(subStr);
                }

                StringBuilder stringBuilder1 = new StringBuilder(subStr);
                while (stringBuilder1.length() < str1.length()) {
                    stringBuilder1.append(subStr);
                }
                if (stringBuilder.toString().equals(str2) && stringBuilder1.toString().equals(str1)) {
                    if (greatestStr.length()  < subStr.length()) {
                        greatestStr = subStr;
                    }
                }
            }
        }
        return greatestStr;
    }
}
