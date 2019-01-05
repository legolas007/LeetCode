package linkedlist;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Usher
 * @Date: 2019/1/5/0005
 * @Description:
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        List<ListNode> listNodes = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                listNodes.add(listNode);
                listNode = listNode.next;
            }
        }

        listNodes.sort(Comparator.comparingInt(o -> o.val));
        ListNode head=new ListNode(0);
        ListNode tmp= head;
        for (ListNode listNode : listNodes) {
            tmp.next = new ListNode(listNode.val);
            tmp = tmp.next;
        }

        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode tmp = lists[0];

        for (int i = 1; i < lists.length; i++) {
            tmp = mergeTwoLists(tmp, lists[i]);
        }
        return tmp;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return helper(lists, 0, lists.length - 1);
    }

    ListNode helper(ListNode[] lists, int l, int r) {
        if(l == r)
            return lists[l];

        if (l == r-1)
            return mergeTwoLists(lists[l], lists[r]);

        int mid = (l + r) / 2;
        ListNode left = helper(lists, l, mid);
        ListNode right = helper(lists, mid + 1, r);

        return mergeTwoLists(left, right);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }
}
