package linkedlist;


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
    /**
     * 显示方法
     */
    public void display() {
        System.out.print(val + " ");
    }
}

