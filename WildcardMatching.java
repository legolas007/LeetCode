package main.java.com.usher.algorithms.string;

public class WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0|| p.length() == 0) return false;

        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int si, String p, int pj) {
        // index out of range check
        if (si == s.length() || pj == p.length()) {
            if (si == s.length() && pj == p.length()) {
                return true;
            } else {
                return false;
            }
        }

        if (p.charAt(pj) == '*') {
            // remove coninuous *
            while (p.charAt(pj) == '*') {
                pj++;
                // index out of range check
                if (pj == p.length()) return true;
            }

            // compare remaining part of p after * with s
            while (si < s.length() && !helper(s, si, p, pj)) {
                si++;
            }
            // substring of p equals to s
            return si != s.length();
        } else if (s.charAt(si) == p.charAt(pj) || p.charAt(pj) == '?') {
            return helper(s, si + 1, p, pj + 1);
        } else {
            return false;
        }
    }

}
