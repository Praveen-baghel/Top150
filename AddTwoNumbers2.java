/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode n1 = l1, n2 = l2;
        ListNode head = null, temp = null;
        while (n1 != null || n2 != null) {
            int a = n1 != null ? n1.val : 0;
            int b = n2 != null ? n2.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            if (head == null) {
                head = temp = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            if (n1 != null)
                n1 = n1.next;
            if (n2 != null)
                n2 = n2.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }
}