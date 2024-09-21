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
    static int cnt = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return dfs(root,1);
    }
    int dfs(TreeNode root,int curcnt){
        if(root == null){
            return curcnt-1;
        }

        return Math.max(dfs(root.left,curcnt+1),dfs(root.right,curcnt+1));
    }
}