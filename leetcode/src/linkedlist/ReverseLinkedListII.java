package linkedlist;

import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        int i = 1;
        ListNode reversedNewHead = null;// 反转部分链表反转后的头结点
        ListNode reversedTail = null;// 反转部分链表反转后的尾结点
        ListNode oldHead = head;// 原链表的头结点
        ListNode reversePreNode = null;// 反转部分链表反转前其头结点的前一个结点
        ListNode reverseNextNode = null;

        while (head != null) {
            if (i > n)
                break;
            if (i == m - 1) {
                reversePreNode = head;
            }
            if (i >= m && i <= n) {
                if (i == m) {
                    reversedTail = head;
                }

                reverseNextNode = head.next;
                head.next = reversedNewHead;
                reversedNewHead = head;
                head = reverseNextNode;
            } else {
                head = head.next;
            }
            i++;
        }

        reversedTail.next = reverseNextNode;
        if (reversePreNode != null) {
            reversePreNode.next = reversedNewHead;
            return oldHead;
        } else {
            return reversedNewHead;
        }
    }
}
