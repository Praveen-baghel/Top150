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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        int counter = 1, prevVal = head.val;
        ListNode prevNode = head;
        head = head.next;
        while (head != null) {
            if (head.val == prevVal) {
                counter++;
                head = head.next;
                continue;
            }
            if (counter == 1) {
                prev.next = prevNode;
                prev = prev.next;
            }
            counter = 1;
            prevNode = head;
            prevVal = head.val;
            head = head.next;
        }
        if (counter == 1) {
            prev.next = prevNode;
            prev = prev.next;
        }
        prev.next = null;
        return dummy.next;
    }
}