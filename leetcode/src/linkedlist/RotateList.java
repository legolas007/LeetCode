package linkedlist;

/**
 * @Author: Usher
 * @Date: 2019/1/18/0018
 * @Description:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * 循环取余数
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;

        if (head.next== null)
            return head;

        ListNode lenNode = head;
        int length = 0;
        while (lenNode != null) {
            length++;
            lenNode = lenNode.next;
        }

        k %= length;
        for (int i = 0; i < k; i++) {
            ListNode dummy = head;
            ListNode node = dummy;
            ListNode lastNode = dummy.next;

            while (node.next.next != null) {
                node = node.next;
                lastNode = lastNode.next;
            }

            node.next = null;
            ListNode headNode = new ListNode(lastNode.val);
            headNode.next = dummy;
            head = headNode;

        }
        return head;
    }
}
