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
        int len = 0;
        ListNode dummy = new ListNode(0); 
        ListNode cur = head;
        while(cur != null){
            len++;
            cur =  cur.next;
        }
        int pass = len-n;
        cur  = dummy;
        System.out.println(pass);
        for(int i = 0;i<len;i++){
            if(i != pass){
            dummy.next = new ListNode(head.val);
            dummy = dummy.next; 
            }
            head = head.next;
        }
        return cur.next;


    }
}