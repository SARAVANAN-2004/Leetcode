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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val:0;
            int n2 = l2 != null ? l2.val:0;
            // System.out.println(n1+" "+n2);
            int sum = n1+n2+carry;
            ptr.next = new ListNode(sum%10);
            carry = sum/10;
            ptr = ptr.next;


            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) ptr.next  = new ListNode(carry);
        return head.next;
    }
}