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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode minHead = new ListNode(-1);
        ListNode maxHead = new ListNode(-1);
        ListNode minTail = minHead, maxTail = maxHead;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                minTail.next = temp;
                minTail = minTail.next;
            } else {
                maxTail.next = temp;
                maxTail = maxTail.next;
            }
            temp = temp.next;
        }
        minTail.next = maxHead.next;
        maxTail.next = null;
        return minHead.next;

    }
}