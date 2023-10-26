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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int m = n / k;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = prev.next, next = null, newTail = prev.next;
        ListNode result = dummy;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = next;
            }
            newTail.next = curr;
            prev = newTail;
            newTail = curr;
        }
        return result.next;

    }
}