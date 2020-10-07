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
    public ListNode reverseList(ListNode head) {
        // points to previous node
        ListNode prev = null;
        // points to current node
        ListNode curr = head;
        // points to next node
        ListNode next = null;
        
        while(curr!=null)
        {
            // holds next node in typical order
            next = curr.next;
            // make the current node point to the previous node
            curr.next = prev;
            // previous node is now set to this iteration's current node for the next iteration
            // effectively this makes the next node point to latest added previous node
            prev = curr;
            // current node is set to the next node for the next iteration
            curr = next;
        }
        return prev;
    }
}
