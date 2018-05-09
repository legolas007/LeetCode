package string;

/**
 * @Author: Usher
 * @Description:
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        for(int i=1;i <= strs[0].length();i++){
            String  s = strs[0].substring(0,i);
            if(longestPrefix(strs,s)){
                continue;
            }else {
                return strs[0].substring(0,s.length());
            }
        }
        return strs[0];
    }
    private boolean longestPrefix(String[] strings, String s){
        for (int i =1;i < strings.length;i++){
            if (!strings[i].startsWith(s)){
                return false;
            }
        }
        return true;
    }
}
