package linkedlist;

/**
 * @Author: Usher
 * @Description:
 */
public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        for (ListNode head = root; head != null; head = head.next) len++;

        int l = len / k;
        int r = len % k;
        ListNode head = root;
        ListNode prev = null;

        for (int i = 0; i < k; i++, r--) {
            ans[i] = head;
            int part_len = l + ((r > 0) ? 1 : 0);
            for (int j = 0; j < part_len; j++) {
                prev = head;
                head = head.next;
            }
            if (prev != null)
                prev.next = null;
        }
        return ans;
    }
}
