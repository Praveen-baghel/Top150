class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int n = 0;
        ListNode temp = head;
        ListNode tailNode = null;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tailNode = temp;
        tailNode.next = head;

        temp = head;
        k = k % n;
        for (int i = 1; i < n - k; k++) {
            temp = temp.next;
        }
        ListNode result = temp.next;
        temp.next = null;
        return result;
    }
}

/* ChatGpt
    class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the linked list and the tail node
        int n = 1;
        ListNode temp = head;
        ListNode tailNode = null;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        tailNode = temp;

        // Calculate the actual rotation count
        k = k % n;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Find the new tail node (n - k - 1 steps from the head)
        temp = head;
        for (int i = 1; i < n - k; i++) {
            temp = temp.next;
        }

        // Perform rotation
        ListNode newHead = temp.next;
        temp.next = null; // Disconnect the new tail from the rotated part
        tailNode.next = head; // Connect the original tail to the original head

        return newHead;
    }
}

 */