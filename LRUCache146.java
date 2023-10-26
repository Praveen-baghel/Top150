import java.util.*;

class LRUCache {

    class ListNode {
        int key, val;
        ListNode prev, next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, ListNode> map;
    ListNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            addToFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() >= capacity) {
                ListNode nodeToRemove = tail.prev;
                removeNode(nodeToRemove);
                map.remove(nodeToRemove.key);
            }
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
