package linkedlist;

/**
 * @Author: Usher
 * @Date: 2019/12/22,0022
 * @Description:
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {

        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }
}
