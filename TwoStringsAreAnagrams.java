package main.java.com.usher.algorithms.array;

import java.util.Arrays;

public class TwoStringsAreAnagrams {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        s = Arrays.toString(ss);
        t = Arrays.toString(tt);
       if(s.compareTo(t) == 0){
           return true;
       }
       return false;
    }
}
