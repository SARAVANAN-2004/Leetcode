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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(0,head);
        ListNode lefthead = dummy;
        ListNode curr = dummy;
        for(int i = 0;i<left;i++){
            
            lefthead = curr;
            curr = curr.next;
            

        }
        // return lefthead;
        ListNode tail = curr;
        ListNode prev = null;
        while(left<=right && curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            left++;
        }
        lefthead.next = prev;
        tail.next = curr;
        return dummy.next;
    }
}