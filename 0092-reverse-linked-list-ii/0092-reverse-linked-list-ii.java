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
    int cnt = 0;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode rev = reverse(head);
        ListNode revptr = rev;
        ListNode headptr = head;
        for(int  i = 0;i<right;i++){
            if(i >= left-1){
                System.out.println(i);
                headptr.val = revptr.val;
            }
            revptr = revptr.next;
            headptr = headptr.next;
        }
        // System.out.println(cnt);
        return head;
    }

    ListNode reverse(ListNode head){
        ListNode dummy =null;
        ListNode prev = dummy;
        ListNode ptr = head;
        while(ptr != null){
            cnt++;
            ListNode node = new ListNode(ptr.val);
           
            node.next = prev;
            prev = node;
            ptr = ptr.next;

        }   
        return prev;
    }
}