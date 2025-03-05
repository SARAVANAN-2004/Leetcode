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
        int len=0;
        ListNode itr=head;
        while (itr != null){
            len++;
            itr=itr.next;
        }
        // when len is 0 or 1
        if (n==1 && (head == null || head.next == null)){
            return null;
        }
        // delete the first node 
        if (len==n) {
            head=head.next;
            return head;
        }
        // locate the n-k-1 node
        int c= 0;
        itr=head;
        // traverse upto n=k-1 node 
        while (c< len-n-1){
            itr=itr.next;
            c++;
        }
       
        itr.next=itr.next.next;
        return head;


    }
}