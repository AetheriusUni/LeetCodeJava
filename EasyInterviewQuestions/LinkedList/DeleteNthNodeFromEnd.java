// delete the nth node from the end of a list

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


// Given list [1, 2, 3, 4, 5] 
// n = 2
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // duplicate head in a separate listnode
        // need to do this just in case listnode only has one element and that has to be deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int length = 0;
        
        // naming convention is by order of pointers
        // so first = first pointer
        // we are starting the first pointer off at the head
        ListNode first = head;

        // finding length of the listnode
        // if next node is null, we're at the end of the list
        while(first!=null)
        {
            first = first.next; // 2, 3, 4, 5, null
            length++;
        }
        // length should be 5 at this point
        
        // gives us the location of the element to be removed
        length -= n;    // 5-2 = 3, so the 4th element
        
        // resets first to start before the head just in case we had only one item in the listnode
        first = dummy;
        
        // until we hit one before the element to be deleted
        while (length > 0)
        {
            first = first.next; // 1, 2, 3
            length--;
        }
        
        // make the element to be deleted point to its next node
        // this effectively deletes it
        first.next = first.next.next;   // make the thing after 3, which is 4, point to 5 instead, so 3's next will become 5
        
        // return dummy.next since that's the entire listnode, excluding the extra space before the first element of head
        return dummy.next;
        // now we return 1, 2, 3, 5 since 3's next node is 5 instead of 4; 4 isn't pointed to at all anymore
    }
}
