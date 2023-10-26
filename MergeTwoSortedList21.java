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
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode n1 = list1, n2 = list2, head = null, tail = null;
		while (n1 != null && n2 != null) {
			ListNode temp = null;
			if (n1.val < n2.val) {
				temp = n1;
				n1 = n1.next;
			} else if (n1.val > n2.val) {
				temp = n2;
				n2 = n2.next;
			} else {
				temp = n1;
				n1 = n1.next;
			}
			if (head == null) {
				head = tail = temp;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
		}
		while (n1 != null) {
			if (head == null) {
				head = tail = n1;
			} else {
				tail.next = n1;
				tail = tail.next;
			}
			n1 = n1.next;
		}
		while (n2 != null) {
			if (head == null) {
				head = tail = n2;
			} else {
				tail.next = n2;
				tail = tail.next;
			}
			n2 = n2.next;
		}
		return head;

	}
}
