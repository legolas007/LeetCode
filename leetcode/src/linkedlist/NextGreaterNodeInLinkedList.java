package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/4/11/0011
 * @Description:
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        ListNode dummy = head;

        Deque<Integer> deque = new ArrayDeque<>();
        int size = 0;
        while (dummy != null) {
            deque.offer(dummy.val);
            dummy = dummy.next;
            size++;
        }

        int[] res = new int[size];
        int i = 0;
        while (head != null) {
            int tmp = head.val;
            boolean flag = true;
            for (int num : deque) {
                if (tmp < num) {
                    res[i++] = num;
                    flag = false;
                    deque.poll();
                    break;
                }
            }

            if (flag) {
                res[i++] = 0;
                deque.poll();
            }

            head = head.next;
        }
        return res;
    }
}
