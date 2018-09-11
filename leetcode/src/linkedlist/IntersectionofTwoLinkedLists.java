package linkedlist;

import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pHead1 = headA;

        ListNode pHead2 = headB;
        if (pHead1 == null || pHead2 == null)
            return null;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode node = null;

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()){
            stack2.pop();
            node =stack1.pop();
        }
        return node;
    }
}
