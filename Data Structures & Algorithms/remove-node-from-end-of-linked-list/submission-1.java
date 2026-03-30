/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        if(head.next == null) return null;

        ListNode dummy = new ListNode(0);
    dummy.next = head;           // ✅ dummy points to head
    ListNode fast = dummy;
    ListNode slow = dummy;       // ✅ both start at dummy

    for(int i = 0; i <= n; i++) { // ✅ n+1 steps to create correct gap
        fast = fast.next;
    }

    while(fast != null) {        // ✅ single loop, no nested checks
        slow = slow.next;
        fast = fast.next;
    }

    slow.next = slow.next.next;  // ✅ skip target node
    return dummy.next;           // ✅ always correct head
    }
}
