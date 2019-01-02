package search;

import java.util.*;
import java.util.function.Function;

/**
 * @Author: Usher
 * @Description:
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int path = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord))
                    return path;

                for (int j = 0; j < curr.length(); j++) {
                    char[] chars = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String sb = new String(chars);
                        if (set.contains(sb)) {
                            queue.offer(sb);
                            set.remove(sb);
                        }
                    }
                }
            }
            path++;
        }
        return 0;
    }
}