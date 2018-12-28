package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2018/12/22/0022
 * @Description:
 */
public class CopyListwithRandomPointer {
    private HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();

    public RandomListNode getClonedNode(RandomListNode node) {

        if (node != null) {
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                this.visited.put(node, new RandomListNode(node.label));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(oldNode.label);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

}
