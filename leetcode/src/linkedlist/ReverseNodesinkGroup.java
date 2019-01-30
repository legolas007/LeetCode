package linkedlist;

/**
 * @Author: Usher
 * @Date: 2019/1/19/0019
 * @Description:
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), pre = dummy, cur = pre;

        dummy.next = head;
        int num = 0;
        while (cur.next != null) {
            cur = cur.next;
            num++;
        }

        while (num >= k) {
            cur = pre.next;

            for (int i = 1; i < k; i++) {
                ListNode tmp = cur.next;

                cur.next = tmp.next;
                tmp.next = pre.next;

                pre.next = tmp;
            }

            pre = cur;
            num -= k;
        }
        return dummy.next;
    }
}
