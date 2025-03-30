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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while(temp != null) {
            n++;
            temp  = temp.next;
        }
        int[] arr = new int[n];
        if(n == 0) return head;
        k = k % n;
        int i = 0;
        temp = head;
        while(temp != null){
            arr[i++] = temp.val;
            temp = temp.next;
        }
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        i = 0;
        ListNode ptr = head;
        while(ptr != null){
            ptr.val = arr[i++];
            ptr = ptr.next;
        }
        return head;
    }

    void reverse(int[] arr,int l,int h){
        while(l < h){
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
            l++;
            h--;
        }
    }
}