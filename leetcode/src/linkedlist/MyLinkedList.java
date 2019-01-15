package linkedlist;

/**
 * @Author: Usher
 * @Date: 2019/1/14/0014
 * @Description:
 */
class MyLinkedList {

    private ListNode head;
    private int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size)
            return -1;
        ListNode current = head;
       for (int i =0;i < index;i++){
            current = current.next;
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;

        if (index == 0) {
            addAtHead(val);
        } else {

            size++;
            ListNode node = head;

            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }


            ListNode tmp = new ListNode(val);
            tmp.next = node.next;
            node.next = tmp;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size)
            return;

        size--;

        ListNode node = head;
        for (int i = 0; i < index-1; i++) {
            node = node.next;
        }

        node.next = node.next.next;

    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
