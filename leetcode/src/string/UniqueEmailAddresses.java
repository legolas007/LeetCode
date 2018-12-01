package string;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for (String email: emails) {
            int i = email.indexOf('@');
            String rest = email.substring(i);
            seen.add(rest);
        }
        return seen.size();
    }
}
