/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        solve(root,Integer.MIN_VALUE);
        return cnt;
    }
    void solve(TreeNode root,int max){
        if(root == null) return;

        if(root.val >= max) cnt++;

        solve(root.left,Math.max(root.val,max));
        solve(root.right,Math.max(root.val,max));
    }
}