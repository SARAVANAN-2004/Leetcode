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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = new int[n];
            Arrays.fill(arr[i], -1);
        }
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;
        int cnt = 0;
        while(head!= null && left <=  right && top <= bottom){
            if(cnt == 0){
                for(int i = left;i<right+1;i++){
                    if(head == null){
                        return arr;
                    }
                    arr[top][i] = head.val;
                    head = head.next;
                }
                top++;
            }else if(cnt == 1){
                for(int i = top;i<bottom+1;i++){
                    if(head == null){
                        return arr;
                    }
                    arr[i][right] = head.val;
                    head = head.next;
                }
                right--;
            }else if(cnt == 2){
                for(int i = right;i>=left;i--){
                    if(head == null){
                        return arr;
                    }
                    arr[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }else{
                for(int i = bottom;i>=top;i--){
                    if(head == null){
                        return arr;
                    }
                    arr[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
            cnt++;
            cnt%=4;
        }
        return arr;
    }
}