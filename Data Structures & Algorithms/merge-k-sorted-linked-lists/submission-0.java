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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
            (a, b) -> a.val - b.val
        );

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // populate the head of each list in the Min Heap
        for(ListNode list : lists) {
            heap.offer(list);
        }

        while(!heap.isEmpty()) {
            ListNode min = heap.poll();

            curr.next = min; // 1
            curr = curr.next; // null

            // if there are more elements in each List add them to heap
            if(min.next != null) {
                heap.offer(min.next);
            }
        }

        return dummy.next;
    }
}
