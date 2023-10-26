import java.util.*;

// Using set or list
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> list = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (list.contains(temp))
                return true;
            list.add(temp);
            temp = temp.next;
        }
        return false;
    }
}

// Using fast and slow pointers
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}