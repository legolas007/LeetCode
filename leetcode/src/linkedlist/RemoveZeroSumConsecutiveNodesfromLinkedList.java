package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/9/1,0001
 * @Description:
 */
public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        boolean found = true;

        while(found) {
            found = false;
            ListNode p = head;
            int sum = 0;

            while (p != null) {
                sum += p.val;

                if(sum==0){
                    head = p.next;
                    map.clear();
                    found = true;
                    break;
                }else if (map.containsKey(sum)) {
                    map.get(sum).next = p.next;
                    map.clear();
                    found = true;
                    break;
                }

                map.put(sum,p);
                p = p.next;
            }
        }

        return head;
    }
}
