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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = length(head);
        ListNode[] arr = new ListNode[k];
        int size = len /k;
        int extra = len % k;
        // System.out.println(size);

        ListNode ptr = head;
        for(int i = 0;i<k && ptr != null;i++){
            int cur = size + (extra > 0 ? 1:0);
            // System.out.println(cur);
            extra--;
            arr[i] = ptr;
            int j = 1;
            while(ptr != null && j < cur){
                j++;
                ptr = ptr.next;
            }
            if(ptr != null){
                ListNode next = ptr.next;
                ptr.next = null;
                ptr = next;
            }
            
        }
        return arr;
    }

    
    int length(ListNode head){
        int cnt = 0;
        while(head != null){
            head = head.next;
            cnt++;
        }
        return cnt;
    }
}