package linkedlist;

/**
 * @Author: Usher
 * @Description:
 */
public class Solution {
    private int len;
    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        len = 0;
        ListNode cur = head;
        this.head = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int t = (int) (Math.random() * len);
        ListNode cur = head;
        while (t != 0) {
            t--;
            cur = cur.next;
        }
        return cur.val;
    }
}
