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
        List<Integer> arr = new ArrayList<>();
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int n = arr.size();
        if(n == 0) return head;
        k = k % n;

        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        int i = 0;
        ListNode ptr = head;
        while(ptr != null){
            ptr.val = arr.get(i++);
            ptr = ptr.next;
        }
        return head;
    }

    void reverse(List<Integer> arr,int l,int h){
        while(l < h){
            int t = arr.get(l);
            arr.set(l,arr.get(h));
            arr.set(h,t);
            l++;
            h--;
        }
    }
}