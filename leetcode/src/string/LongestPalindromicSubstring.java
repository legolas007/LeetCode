package string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s == null) {
            return "";
        }

        int longest = 0,left = 0,right = 0;
        for (int i = 0;i < s.length();i++){
            for (int j = i+1;j <= s.length();j++){
                String subStr = s.substring(i,j);
                if(isPalindrome(subStr) && subStr.length() > longest){
                    longest = subStr.length();
                    left = i;
                    right = j;
                }
            }
        }
        String res = s.substring(left,right);
        return res;
    }
    private boolean isPalindrome(String s){
        if (s == null || s.isEmpty()) return false;

        for (int i =0; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

}

/**
 public class Solution {
 public String longestPalindrome(String s) {
 String res = "";
 int currLength = 0;
 for(int i=0;i<s.length();i++){
 if(isPalindrome(s,i-currLength-1,i)){
 res = s.substring(i-currLength-1,i+1);
 currLength = currLength+2;
 }
 else if(isPalindrome(s,i-currLength,i)){
 res = s.substring(i-currLength,i+1);
 currLength = currLength+1;
 }
 }
 return res;
 }

 public boolean isPalindrome(String s, int begin, int end){
 if(begin<0) return false;
 while(begin<end){
 if(s.charAt(begin++)!=s.charAt(end--)) return false;
 }
 return true;
 }
 }*/
