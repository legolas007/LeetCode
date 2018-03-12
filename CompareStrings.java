package main.java.com.usher.algorithms.array;

import java.util.HashMap;

public class CompareStrings {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        char[] A1 = A.toCharArray();
        char[] B1 = B.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for (char c : A1){
            if(!hm.containsKey(c)){
                hm.put(c,1);
            }else {
                hm.put(c,hm.get(c)+1);
            }
        }

        for (char c : B1){
            if (!hm.containsKey(c)){
                return false;
            }else if (hm.get(c) <= 0){
                return false;
            }else {
                hm.put(c,hm.get(c)-1);
            }
        }
        return true;
    }
}
