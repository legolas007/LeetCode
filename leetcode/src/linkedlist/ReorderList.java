package linkedlist;

/**
 * @Author: Usher
 * @Date: 2019/6/9/0009
 * @Description:
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        //中间节点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //后半段断开
        ListNode mid = slow.next;
        slow.next = null;

        //后半段反转
        ListNode pre = null;
        ListNode cur = mid;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //拼接
        while (head != null && pre != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next;
            head = next;
        }
    }
}
