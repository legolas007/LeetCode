package linkedlist;

/**
 * @Author: Usher
 * @Date: 2019/1/19/0019 
 * @Description:
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
