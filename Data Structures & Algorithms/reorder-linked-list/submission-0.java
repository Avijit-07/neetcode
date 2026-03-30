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
    public void reorderList(ListNode head) {
        
        // finding the middle point
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // assign the second half of the list
        ListNode secondList = slow.next;
        slow.next = null;

        // rotate the second list
        ListNode preNode = null;
        ListNode currNode = secondList;

        while(currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        // merge two lists
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        
        while(head != null && preNode != null) {
            result.next = head;
            result = result.next;
            head = head.next;

            result.next = preNode;
            result = result.next;
            preNode = preNode.next;
        }

        if(head != null) result.next = head;
        if(preNode != null) result.next = preNode;

    }
}
