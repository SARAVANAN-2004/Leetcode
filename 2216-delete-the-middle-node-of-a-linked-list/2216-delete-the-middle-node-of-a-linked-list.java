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
    public ListNode deleteMiddle(ListNode head) {
        ListNode ptr = head;
        int cnt = 0;
        while(ptr!=null){
            ptr = ptr.next;
            cnt++;
        }
        if(cnt == 1) return null;
        int mid = cnt / 2;
        ptr = head;
        for(int i = 0;i<mid-1;i++){
            ptr = ptr.next;
        }
        if(ptr.next == null || ptr.next.next == null){
            ptr.next = null;
        }else{
        ptr.next = ptr.next.next;
        }

        return head;
    }
}