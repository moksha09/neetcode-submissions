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

        // Using Divide and Conquer Approach - 
        if(lists==null || lists.length==0){
            return null;
        }
        return divide(lists, 0, lists.length-1);
    }

    public ListNode divide(ListNode[] lists, int start, int end){
        // base case - 
        if(lists==null) return null;
        if(end<start) return null;
        if(start==end) return lists[start];

        int mid = (start+end)/2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid+1, end);

        // conquer - 
        return conquer(left, right);
    }

    public ListNode conquer(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(left!=null && right!=null){
            if(left.val<=right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if(left!=null){
            current.next = left;
        }
        if(right!=null){
            current.next = right;
        }

        return dummy.next;
    }
}
