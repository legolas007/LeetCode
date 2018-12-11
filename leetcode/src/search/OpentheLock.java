package search;

import java.util.*;

/**
 * @Author: Usher
 * @Description:
 */
public class OpentheLock {
    private static Map<Character, char[]> moves = new HashMap<>();
    static {
        moves.put('0', new char[]{'1', '9'});
        moves.put('1', new char[]{'2', '0'});
        moves.put('2', new char[]{'3', '1'});
        moves.put('3', new char[]{'4', '2'});
        moves.put('4', new char[]{'5', '3'});
        moves.put('5', new char[]{'6', '4'});
        moves.put('6', new char[]{'7', '5'});
        moves.put('7', new char[]{'8', '6'});
        moves.put('8', new char[]{'9', '7'});
        moves.put('9', new char[]{'0', '8'});
    }
    public int openLock(String[] deadends, String target) {
        if (target == null || target.equals("")) {
            return -1;
        }

        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) {
            return -1;
        }

        Set<String> used = new HashSet<>();
        Queue<char[]> q = new ArrayDeque<>();
        int steps = 0;
        q.offer("0000".toCharArray());
        used.add("0000");

        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                char[] code = q.poll();
                for (int i = 0; i < code.length; i++) {
                    for (char mov : moves.get(code[i])) {
                        char[] newCode = code.clone();
                        newCode[i] = mov;
                        String val = String.valueOf(newCode);
                        if (target.equals(val)) {
                            return ++steps;
                        }

                        if (!deads.contains(val) && !used.contains(val)) {
                            q.offer(newCode);
                            used.add(val);
                        }
                    }
                }
            }
            ++steps;
        }
        return -1;

    }
}
