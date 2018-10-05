package linkedlist;

/**
 * @Author: Usher
 * @Description:
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
