import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Using java collection frameworks
class BSTIterator {

    Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        createLinkedList(root);
    }

    private void createLinkedList(TreeNode root) {
        if (root == null)
            return;
        createLinkedList(root.left);
        queue.add(root.val);
        createLinkedList(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

// Using my own LinkedList
class BSTIterator {
    class Node {
        int val;
        Node next;

        public Node(int value) {
            this.val = value;
            this.next = null;
        }
    }

    Node head, tail;

    public BSTIterator(TreeNode root) {
        this.head = new Node(-1);
        tail = head;
        createInorder(root);
    }

    private void createInorder(TreeNode root) {
        if (root == null)
            return;
        createInorder(root.left);
        tail.next = new Node(root.val);
        tail = tail.next;
        createInorder(root.right);
    }

    public int next() {
        int result = head.next.val;
        head = head.next;
        return result;
    }

    public boolean hasNext() {
        return head.next != null;
    }
}