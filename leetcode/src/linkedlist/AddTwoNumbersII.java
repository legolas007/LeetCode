package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Usher
 * @Description:
 * 遍历两个链表，将所有数字分别压入两个栈s1和s2中，我们建立一个值为0的res节点，然后开始循环，如果栈不为空，则将栈顶数字加入sum中，
 * 然后将res节点值赋为sum%10，然后新建一个进位节点head，赋值为sum/10，如果没有进位，那么就是0，然后我们head后面连上res，将res指向head，
 * 这样循环退出后，我们只要看res的值是否为0，为0返回res->next，不为0则返回res即可
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        while (l1 != null) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode result = new ListNode(0);
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            if (!deque1.isEmpty()) {
                sum += deque1.pop();
            }
            if (!deque2.isEmpty()) {
                sum += deque2.pop();
            }

            result.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = result;
            result = head;
            sum /= 10;
        }
        return result.val == 0 ? result.next : result;
    }
}
