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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        // head is our moving pointer so dummy doesn't change where it's pointing to
        ListNode head = dummy;
        
        // while neither of the lists are exhausted yet
        while(l1!=null && l2!=null)
        {
            // point head to the lowest value, or default to l1's value if the values are even
            if(l1.val<=l2.val)
            {
                head.next = l1;
                l1 = l1.next;
            }
            else
            {
                head.next = l2;
                l2 = l2.next;
            }
            // moves pointer to the next value
            head = head.next;
        }
        // if either of the ListNodes aren't null, make head point to it
        // this effectively adds the remaining values to the end of the singly linked list
        if(l1!=null)
        {
            head.next = l1;
        }
        else
        {
            head.next = l2;
        }
        
        // now that everything is done in head, dummy.next will return the correct range of values
        // since the first value in ListNode is 0 and not part of the ListNodes in this problem
        return dummy;
    }
}
