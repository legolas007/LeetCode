package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Usher
 * @Description:
 *
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 *
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        int ans = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null|| !set.contains(head.next.val))) {
                ans++;
            }
            head = head.next;
        }
        return ans;
    }
}
