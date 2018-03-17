package main.java.com.usher.algorithms.string;

import java.util.Scanner;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Example
Clarification

- What constitutes a word?
A sequence of non-space characters constitutes a word.

- Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.

- How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

 */
public class ReverseWordsInAString {

    /**
     *
     * @param s:A string
     * @return:A string
     */
    public String reverseWords(String s){
        Scanner scanner = new Scanner(s);

        String result = "";
        while (scanner.hasNext()){
            result = scanner.next() + " " + result;
        }
        return result.trim();
    }
}
