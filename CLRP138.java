import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = null, newTail = null;
        while (head != null) {
            if (!map.containsKey(head)) {
                Node newNode = new Node(head.val);
                map.put(head, newNode);
                if (newHead == null) {
                    newHead = newNode;
                    newTail = newNode;
                } else {
                    newTail.next = newNode;
                    newTail = newTail.next;
                }
            } else {
                newTail.next = map.get(head);
                newTail = newTail.next;
            }

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newTail.random = map.get(head.random);
                } else {
                    Node newRand = new Node(head.random.val);
                    map.put(head.random, newRand);
                    newTail.random = newRand;
                }
            }
            head = head.next;
        }
        return newHead;
    }
}
