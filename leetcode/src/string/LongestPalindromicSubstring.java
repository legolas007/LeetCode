package string;

public class LongestPalindromicSubstring {
    private int index, len;
    public String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        for(int i = 0; i < s.length()-1; i++){
            PalindromeHelper(s, i, i);
            PalindromeHelper(s, i, i+1);
        }
        return s.substring(index, index+len);
    }
    private void PalindromeHelper(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(len < r - l - 1){
            index = l + 1;
            len = r - l - 1;
        }
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
