package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Usher
 * @Date: 2019/5/18/0018
 * @Description:
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;

        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray())
                s.add(c);
            return s.size() < A.length();
        }

        List<Integer> dif = new ArrayList<>();

        for (int i = 0; i < A.length(); ++i)
            if (A.charAt(i) != B.charAt(i))
                dif.add(i);

        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}
