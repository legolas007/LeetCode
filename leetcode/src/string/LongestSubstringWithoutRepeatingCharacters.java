package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 *
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s)
    {
        int max = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ;i < chars.length;i++)
        {
            if(!map.containsKey(chars[i])) map.put(chars[i], i);
            else
            {
                if(max < map.size()) max = map.size();
                i = map.get(chars[i]);
                map.clear();
            }
        }
        return max>map.size()?max:map.size();
    }
}
