package array;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2018/12/31/0031
 * @Description: start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * return: 3
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0)
            return -1;

        char[] gens = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        //Set<String> visited = new HashSet<>();
        queue.offer(start);
        int path = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(end)) {
                    return path;
                }

                for (int j = 0; j < cur.length(); j++) {
                    char[] chars = cur.toCharArray();
                    for (char ch : gens) {
                        chars[j] = ch;
                        String sb = new String(chars);

                        //if (set.contains(sb) && !visited.contains(sb)) {
                        if (set.contains(sb)) {
                            queue.offer(sb);
                           // visited.add(sb);
                            set.remove(sb);
                        }
                    }
                }

            }
            path++;
        }
        return -1;
    }
}
