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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        dfs(root,1);
        return cnt;
    }
    void dfs(TreeNode root,int curcnt){
        if(root == null){
            cnt = Math.max(cnt,curcnt-1);
            return ;
        }
        dfs(root.left,curcnt+1);
        dfs(root.right,curcnt+1);
    }
}