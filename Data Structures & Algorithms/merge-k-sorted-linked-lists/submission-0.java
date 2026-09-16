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

        // Usign a Priority Queue to store the hirst elements of each linked list - 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // PUT THE Heads in the PQ - 
        for(ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
        }

        // NOW compare - 
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}
