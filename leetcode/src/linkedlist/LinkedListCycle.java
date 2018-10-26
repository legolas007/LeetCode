package linkedlist;

/**
 * @Author: Usher
 * @Description:
 *
 * Given a linked list, determine if it has a cycle in it.
    Example
    Given -21->10->4->5, tail connects to node index 1, return true

    Challenge
    Follow up:
    Can you solve it without using extra space?

 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next)
            return false;
        ListNode slow = head,fast = head.next;
        while (null != fast&&null!=fast.next){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode slow = pHead, fast = pHead.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == null) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
