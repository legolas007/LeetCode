package search;

/**
 * @Author: Usher
 * @Description:
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i =0;i < letters.length;i++)
            if (target < letters[i])
                return letters[i];
            else continue;
        return letters[0];
    }

    
}
