package linkedlist;

/**
 * @Author: Usher
 * @Date: 2018/12/26/0026
 * @Description:
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
public class SortList {
    /**
     * 快速
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        quickSort(head, null);
        return head;
    }

    void quickSort(ListNode head, ListNode tail) {
        if (head != tail && head.next != tail) {
            ListNode mid = partition(head, tail);
            quickSort(head, mid);
            quickSort(mid.next, tail);
        }
    }

    ListNode partition(ListNode low, ListNode high) {
        int key = low.val;
        ListNode loc = low;

        for (ListNode i = low.next; i != high; i = i.next) {
            if (i.val < key) {
                loc = loc.next;
                int swapVal = i.val;
                i.val = loc.val;
                loc.val = swapVal;
            }

        }
        int swapVal = loc.val;
        loc.val = low.val;
        low.val = swapVal;
        return loc;
    }


    /**
     * 归并
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

}
