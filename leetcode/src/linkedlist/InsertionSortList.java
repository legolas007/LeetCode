package linkedlist;

/**
 * @Author: Usher
 * @Date: 2018/12/24/0024
 * @Description:
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode cur;
        while (head != null) {
            ListNode tmp = head.next;
            cur = dummy;
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }

            head.next = cur.next;
            cur.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
